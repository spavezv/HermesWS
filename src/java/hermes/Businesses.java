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
@Table(name = "businesses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Businesses.findAll", query = "SELECT b FROM Businesses b"),
    @NamedQuery(name = "Businesses.findById", query = "SELECT b FROM Businesses b WHERE b.id = :id"),
    @NamedQuery(name = "Businesses.findByName", query = "SELECT b FROM Businesses b WHERE b.name = :name"),
    @NamedQuery(name = "Businesses.findByOwner", query = "SELECT b FROM Businesses b WHERE b.owner = :owner"),
    @NamedQuery(name = "Businesses.findByEmail", query = "SELECT b FROM Businesses b WHERE b.email = :email"),
    @NamedQuery(name = "Businesses.findByCreatedAt", query = "SELECT b FROM Businesses b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "Businesses.findByUpdatedAt", query = "SELECT b FROM Businesses b WHERE b.updatedAt = :updatedAt")})
public class Businesses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "owner")
    private String owner;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
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
    @OneToMany(mappedBy = "businessId")
    private Collection<Branches> branchesCollection;
    @OneToMany(mappedBy = "businessId")
    private Collection<Workers> workersCollection;

    public Businesses() {
    }

    public Businesses(Integer id) {
        this.id = id;
    }

    public Businesses(Integer id, Date createdAt, Date updatedAt) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public Collection<Branches> getBranchesCollection() {
        return branchesCollection;
    }

    public void setBranchesCollection(Collection<Branches> branchesCollection) {
        this.branchesCollection = branchesCollection;
    }

    @XmlTransient
    public Collection<Workers> getWorkersCollection() {
        return workersCollection;
    }

    public void setWorkersCollection(Collection<Workers> workersCollection) {
        this.workersCollection = workersCollection;
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
        if (!(object instanceof Businesses)) {
            return false;
        }
        Businesses other = (Businesses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.Businesses[ id=" + id + " ]";
    }

}
