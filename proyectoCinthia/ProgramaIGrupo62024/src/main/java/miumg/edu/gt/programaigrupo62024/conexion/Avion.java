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
@Table(name = "avion", catalog = "grupo6", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a"),
    @NamedQuery(name = "Avion.findById", query = "SELECT a FROM Avion a WHERE a.id = :id"),
    @NamedQuery(name = "Avion.findByMarca", query = "SELECT a FROM Avion a WHERE a.marca = :marca"),
    @NamedQuery(name = "Avion.findByModelo", query = "SELECT a FROM Avion a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Avion.findByColor", query = "SELECT a FROM Avion a WHERE a.color = :color"),
    @NamedQuery(name = "Avion.findByPasajeros", query = "SELECT a FROM Avion a WHERE a.pasajeros = :pasajeros")})
public class Avion implements Serializable {

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
    @Column(name = "pasajeros", nullable = false)
    private int pasajeros;

    public Avion() {
    }

    public Avion(Integer id) {
        this.id = id;
    }

    public Avion(Integer id, String marca, String modelo, String color, int pasajeros) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.pasajeros = pasajeros;
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

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
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
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "miumg.edu.gt.programaigrupo62024.conexion.Avion[ id=" + id + " ]";
    }
    
}
