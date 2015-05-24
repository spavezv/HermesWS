/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sergio Josemar Pavez Vera
 */
@Entity
@Table(name = "blocks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blocks.findAll", query = "SELECT b FROM Blocks b"),
    @NamedQuery(name = "Blocks.findById", query = "SELECT b FROM Blocks b WHERE b.id = :id"),
    @NamedQuery(name = "Blocks.findByDate", query = "SELECT b FROM Blocks b WHERE b.date = :date"),
    @NamedQuery(name = "Blocks.findByStart", query = "SELECT b FROM Blocks b WHERE b.start = :start"),
    @NamedQuery(name = "Blocks.findByFinish", query = "SELECT b FROM Blocks b WHERE b.finish = :finish"),
    @NamedQuery(name = "Blocks.findByPrice", query = "SELECT b FROM Blocks b WHERE b.price = :price"),
    @NamedQuery(name = "Blocks.findByCreatedAt", query = "SELECT b FROM Blocks b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "Blocks.findByUpdatedAt", query = "SELECT b FROM Blocks b WHERE b.updatedAt = :updatedAt")})
public class Blocks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "start")
    @Temporal(TemporalType.TIME)
    private Date start;
    @Column(name = "finish")
    @Temporal(TemporalType.TIME)
    private Date finish;
    @Column(name = "price")
    private Integer price;
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
    @JoinColumn(name = "court_id", referencedColumnName = "id")
    @ManyToOne
    private Courts courtId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private Users userId;

    public Blocks() {
    }

    public Blocks(Integer id) {
        this.id = id;
    }

    public Blocks(Integer id, Date createdAt, Date updatedAt) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Courts getCourtId() {
        return courtId;
    }

    public void setCourtId(Courts courtId) {
        this.courtId = courtId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof Blocks)) {
            return false;
        }
        Blocks other = (Blocks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.Blocks[ id=" + id + " ]";
    }

}
