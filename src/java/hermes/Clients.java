/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hermes;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Blob;

/**
 *
 * @author Sergio Josemar Pavez Vera
 */
@Entity
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
    @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email"),
    @NamedQuery(name = "Clients.findByEncryptedPassword", query = "SELECT c FROM Clients c WHERE c.encryptedPassword = :encryptedPassword"),
    @NamedQuery(name = "Clients.findByResetPasswordToken", query = "SELECT c FROM Clients c WHERE c.resetPasswordToken = :resetPasswordToken"),
    @NamedQuery(name = "Clients.findByResetPasswordSentAt", query = "SELECT c FROM Clients c WHERE c.resetPasswordSentAt = :resetPasswordSentAt"),
    @NamedQuery(name = "Clients.findByRememberCreatedAt", query = "SELECT c FROM Clients c WHERE c.rememberCreatedAt = :rememberCreatedAt"),
    @NamedQuery(name = "Clients.findBySignInCount", query = "SELECT c FROM Clients c WHERE c.signInCount = :signInCount"),
    @NamedQuery(name = "Clients.findByCurrentSignInAt", query = "SELECT c FROM Clients c WHERE c.currentSignInAt = :currentSignInAt"),
    @NamedQuery(name = "Clients.findByLastSignInAt", query = "SELECT c FROM Clients c WHERE c.lastSignInAt = :lastSignInAt"),
    @NamedQuery(name = "Clients.findByCreatedAt", query = "SELECT c FROM Clients c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Clients.findByUpdatedAt", query = "SELECT c FROM Clients c WHERE c.updatedAt = :updatedAt"),
    @NamedQuery(name = "Clients.findByName", query = "SELECT c FROM Clients c WHERE c.name = :name"),
    @NamedQuery(name = "Clients.findByLastname", query = "SELECT c FROM Clients c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Clients.authenticate", query = "SELECT c FROM Clients c WHERE c.email = :email AND c.encryptedPassword = :password")})
public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "encrypted_password")
    private String encryptedPassword;
    @Size(max = 2147483647)
    @Column(name = "reset_password_token")
    private String resetPasswordToken;
    @Column(name = "reset_password_sent_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resetPasswordSentAt;
    @Column(name = "remember_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rememberCreatedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sign_in_count")
    private int signInCount;
    @Column(name = "current_sign_in_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currentSignInAt;
    @Column(name = "last_sign_in_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSignInAt;
    @Lob
    @Column(name = "current_sign_in_ip")
    private InetAddress currentSignInIp;
    @Lob
    @Column(name = "last_sign_in_ip")
    private InetAddress lastSignInIp;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "phone")
    private String phone;

    public Clients() {
    }

    public Clients(Integer id) {
        this.id = id;
    }

    public Clients(Integer id, String email, String encryptedPassword, int signInCount) {
        this.id = id;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.signInCount = signInCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public Date getResetPasswordSentAt() {
        return resetPasswordSentAt;
    }

    public void setResetPasswordSentAt(Date resetPasswordSentAt) {
        this.resetPasswordSentAt = resetPasswordSentAt;
    }

    public Date getRememberCreatedAt() {
        return rememberCreatedAt;
    }

    public void setRememberCreatedAt(Date rememberCreatedAt) {
        this.rememberCreatedAt = rememberCreatedAt;
    }

    public int getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(int signInCount) {
        this.signInCount = signInCount;
    }

    public Date getCurrentSignInAt() {
        return currentSignInAt;
    }

    public void setCurrentSignInAt(Date currentSignInAt) {
        this.currentSignInAt = currentSignInAt;
    }

    public Date getLastSignInAt() {
        return lastSignInAt;
    }

    public void setLastSignInAt(Date lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    public InetAddress getCurrentSignInIp() {
        return currentSignInIp;
    }

    public void setCurrentSignInIp(InetAddress currentSignInIp) {
        this.currentSignInIp = currentSignInIp;
    }

    public InetAddress getLastSignInIp() {
        return lastSignInIp;
    }

    public void setLastSignInIp(InetAddress lastSignInIp) {
        this.lastSignInIp = lastSignInIp;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.Clients[ id=" + id + " ]";
    }

}
