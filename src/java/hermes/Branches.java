/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergio Josemar Pavez Vera
 */
@Entity
@Table(name = "branches")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branches.findAll", query = "SELECT b FROM Branches b"),
    @NamedQuery(name = "Branches.findById", query = "SELECT b FROM Branches b WHERE b.id = :id"),
    @NamedQuery(name = "Branches.findByCity", query = "SELECT b FROM Branches b WHERE b.city = :city"),
    @NamedQuery(name = "Branches.findByCommune", query = "SELECT b FROM Branches b WHERE b.commune = :commune"),
    @NamedQuery(name = "Branches.findByStreet", query = "SELECT b FROM Branches b WHERE b.street = :street"),
    @NamedQuery(name = "Branches.findByNumber", query = "SELECT b FROM Branches b WHERE b.number = :number"),
    @NamedQuery(name = "Branches.findByCreatedAt", query = "SELECT b FROM Branches b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "Branches.findByUpdatedAt", query = "SELECT b FROM Branches b WHERE b.updatedAt = :updatedAt")})
public class Branches implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "city")
    private String city;
    @Size(max = 2147483647)
    @Column(name = "commune")
    private String commune;
    @Size(max = 2147483647)
    @Column(name = "street")
    private String street;
    @Size(max = 2147483647)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "branchId")
    private Collection<Courts> courtsCollection;
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    @ManyToOne
    private Businesses businessId;

    public Branches() {
    }

    public Branches(Integer id) {
        this.id = id;
    }

    public Branches(Integer id, Date createdAt, Date updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public Collection<Courts> getCourtsCollection() {
        return courtsCollection;
    }

    public void setCourtsCollection(Collection<Courts> courtsCollection) {
        this.courtsCollection = courtsCollection;
    }

    public Businesses getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Businesses businessId) {
        this.businessId = businessId;
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
        if (!(object instanceof Branches)) {
            return false;
        }
        Branches other = (Branches) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.Branches[ id=" + id + " ]";
    }

}
