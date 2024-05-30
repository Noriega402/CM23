package javaJPA;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Root;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.EntityNotFoundException;
import javaJPA.exceptions.NonexistentEntityException;
import miumg.edu.gt.programaigrupo62024.conexion.Balsa;

/**
 *
 * @author Daniel Noriega
 *
 */
public class BalsaJpaController implements Serializable {
    private EntityManagerFactory emf = null;

    public BalsaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Balsa balsa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(balsa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Balsa balsa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            balsa = em.merge(balsa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = balsa.getId();
                if (findBalsa(id) == null) {
                    throw new NonexistentEntityException("The balsa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Balsa balsa;
            try {
                balsa = em.getReference(Balsa.class, id);
                balsa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The balsa with id " + id + " no longer exists.", enfe);
            }
            em.remove(balsa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Balsa> findBalsaEntities() {
        return findBalsaEntities(true, -1, -1);
    }

    public List<Balsa> findBalsaEntities(int maxResults, int firstResult) {
        return findBalsaEntities(false, maxResults, firstResult);
    }

    private List<Balsa> findBalsaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Balsa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Balsa findBalsa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Balsa.class, id);
        } finally {
            em.close();
        }
    }

    public int getBalsaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Balsa> rt = cq.from(Balsa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}