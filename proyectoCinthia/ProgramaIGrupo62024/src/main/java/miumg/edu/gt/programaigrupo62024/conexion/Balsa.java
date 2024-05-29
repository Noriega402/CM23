/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miumg.edu.gt.programaigrupo62024.conexion;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Daniel Noriega
 */
@Entity
@Table(name = "balsa", catalog = "grupo6", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Balsa.findAll", query = "SELECT b FROM Balsa b"),
    @NamedQuery(name = "Balsa.findById", query = "SELECT b FROM Balsa b WHERE b.id = :id"),
    @NamedQuery(name = "Balsa.findByMarca", query = "SELECT b FROM Balsa b WHERE b.marca = :marca"),
    @NamedQuery(name = "Balsa.findByModelo", query = "SELECT b FROM Balsa b WHERE b.modelo = :modelo"),
    @NamedQuery(name = "Balsa.findByColor", query = "SELECT b FROM Balsa b WHERE b.color = :color"),
    @NamedQuery(name = "Balsa.findByTipoMotor", query = "SELECT b FROM Balsa b WHERE b.tipoMotor = :tipoMotor")})
public class Balsa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "marca", nullable = false, length = 2147483647)
    private String marca;
    @Basic(optional = false)
    @Column(name = "modelo", nullable = false, length = 2147483647)
    private String modelo;
    @Basic(optional = false)
    @Column(name = "color", nullable = false, length = 2147483647)
    private String color;
    @Basic(optional = false)
    @Column(name = "tipo_motor", nullable = false, length = 2147483647)
    private String tipoMotor;

    public Balsa() {
    }

    public Balsa(Integer id) {
        this.id = id;
    }

    public Balsa(Integer id, String marca, String modelo, String color, String tipoMotor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipoMotor = tipoMotor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Balsa)) {
            return false;
        }
        Balsa other = (Balsa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "miumg.edu.gt.programaigrupo62024.conexion.Balsa[ id=" + id + " ]";
    }
    
}
