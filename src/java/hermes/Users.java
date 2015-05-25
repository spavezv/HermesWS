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
import javax.persistence.Lob;
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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByEncryptedPassword", query = "SELECT u FROM Users u WHERE u.encryptedPassword = :encryptedPassword"),
    @NamedQuery(name = "Users.findByResetPasswordToken", query = "SELECT u FROM Users u WHERE u.resetPasswordToken = :resetPasswordToken"),
    @NamedQuery(name = "Users.findByResetPasswordSentAt", query = "SELECT u FROM Users u WHERE u.resetPasswordSentAt = :resetPasswordSentAt"),
    @NamedQuery(name = "Users.findByRememberCreatedAt", query = "SELECT u FROM Users u WHERE u.rememberCreatedAt = :rememberCreatedAt"),
    @NamedQuery(name = "Users.findBySignInCount", query = "SELECT u FROM Users u WHERE u.signInCount = :signInCount"),
    @NamedQuery(name = "Users.findByCurrentSignInAt", query = "SELECT u FROM Users u WHERE u.currentSignInAt = :currentSignInAt"),
    @NamedQuery(name = "Users.findByLastSignInAt", query = "SELECT u FROM Users u WHERE u.lastSignInAt = :lastSignInAt"),
    @NamedQuery(name = "Users.findByCreatedAt", query = "SELECT u FROM Users u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "Users.findByUpdatedAt", query = "SELECT u FROM Users u WHERE u.updatedAt = :updatedAt"),
    @NamedQuery(name = "Users.findByLevel", query = "SELECT u FROM Users u WHERE u.level = :level"),
    @NamedQuery(name = "Users.findByPermission", query = "SELECT u FROM Users u WHERE u.permission = :permission"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name")})
public class Users implements Serializable {
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
    private String currentSignInIp;
    @Lob
    @Column(name = "last_sign_in_ip")
    private String lastSignInIp;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "level")
    private Integer level;
    @Column(name = "permission")
    private Integer permission;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "userId")
    private Collection<Blocks> blocksCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Workers> workersCollection;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String email, String encryptedPassword, int signInCount) {
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

    public String getCurrentSignInIp() {
        return currentSignInIp;
    }

    public void setCurrentSignInIp(String currentSignInIp) {
        this.currentSignInIp = currentSignInIp;
    }

    public String getLastSignInIp() {
        return lastSignInIp;
    }

    public void setLastSignInIp(String lastSignInIp) {
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Blocks> getBlocksCollection() {
        return blocksCollection;
    }

    public void setBlocksCollection(Collection<Blocks> blocksCollection) {
        this.blocksCollection = blocksCollection;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hermes.Users[ id=" + id + " ]";
    }

}
