/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jayantha
 */
@Entity
@Table(name = "fertilizer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fertilizer.findAll", query = "SELECT f FROM Fertilizer f")
    , @NamedQuery(name = "Fertilizer.findById", query = "SELECT f FROM Fertilizer f WHERE f.id = :id")
    , @NamedQuery(name = "Fertilizer.findByName", query = "SELECT f FROM Fertilizer f WHERE f.name = :name")
    , @NamedQuery(name = "Fertilizer.findByPrice", query = "SELECT f FROM Fertilizer f WHERE f.price = :price")
    , @NamedQuery(name = "Fertilizer.findByValidFrom", query = "SELECT f FROM Fertilizer f WHERE f.validFrom = :validFrom")})
public class Fertilizer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @Column(name = "validFrom")
    @Temporal(TemporalType.DATE)
    private Date validFrom;

    public Fertilizer() {
    }

    public Fertilizer(Integer id) {
        this.id = id;
    }

    public Fertilizer(Integer id, String name, double price, Date validFrom) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.validFrom = validFrom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
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
        if (!(object instanceof Fertilizer)) {
            return false;
        }
        Fertilizer other = (Fertilizer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Fertilizer[ id=" + id + " ]";
    }
    
}
