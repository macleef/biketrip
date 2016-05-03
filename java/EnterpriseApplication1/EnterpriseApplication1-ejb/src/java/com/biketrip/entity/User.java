/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biketrip.entity;

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
 * @author florian
 */
@Entity
@Table(name = "USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdUSER", query = "SELECT u FROM User u WHERE u.idUSER = :idUSER"),
    @NamedQuery(name = "User.findByUSERName", query = "SELECT u FROM User u WHERE u.uSERName = :uSERName"),
    @NamedQuery(name = "User.findByUserKm", query = "SELECT u FROM User u WHERE u.userKm = :userKm"),
    @NamedQuery(name = "User.findByUSERTemps", query = "SELECT u FROM User u WHERE u.uSERTemps = :uSERTemps")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_USER", nullable = false)
    private Integer idUSER;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USER_Name", nullable = false, length = 45)
    private String uSERName;
    @Column(name = "USER_KM")
    private Integer userKm;
    @Column(name = "USER_Temps")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uSERTemps;
    @OneToMany(mappedBy = "bIKEUser")
    private Collection<Bike> bikeCollection;

    public User() {
    }

    public User(Integer idUSER) {
        this.idUSER = idUSER;
    }

    public User(Integer idUSER, String uSERName) {
        this.idUSER = idUSER;
        this.uSERName = uSERName;
    }

    public Integer getIdUSER() {
        return idUSER;
    }

    public void setIdUSER(Integer idUSER) {
        this.idUSER = idUSER;
    }

    public String getUSERName() {
        return uSERName;
    }

    public void setUSERName(String uSERName) {
        this.uSERName = uSERName;
    }

    public Integer getUserKm() {
        return userKm;
    }

    public void setUserKm(Integer userKm) {
        this.userKm = userKm;
    }

    public Date getUSERTemps() {
        return uSERTemps;
    }

    public void setUSERTemps(Date uSERTemps) {
        this.uSERTemps = uSERTemps;
    }

    @XmlTransient
    public Collection<Bike> getBikeCollection() {
        return bikeCollection;
    }

    public void setBikeCollection(Collection<Bike> bikeCollection) {
        this.bikeCollection = bikeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUSER != null ? idUSER.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUSER == null && other.idUSER != null) || (this.idUSER != null && !this.idUSER.equals(other.idUSER))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biketrip.entity.User[ idUSER=" + idUSER + " ]";
    }
    
}
