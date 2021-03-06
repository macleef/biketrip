/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biketrip.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author florian
 */
@Entity
@Table(name = "BIKE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"BIKE_name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bike.findAll", query = "SELECT b FROM Bike b"),
    @NamedQuery(name = "Bike.findByIdBIKE", query = "SELECT b FROM Bike b WHERE b.idBIKE = :idBIKE"),
    @NamedQuery(name = "Bike.findByBIKEname", query = "SELECT b FROM Bike b WHERE b.bikeName = :bikeName"),
    @NamedQuery(name = "Bike.findByBIKEgroupe", query = "SELECT b FROM Bike b WHERE b.bikeGroupe = :bikeGroupe"),
    @NamedQuery(name = "Bike.findByBIKEkm", query = "SELECT b FROM Bike b WHERE b.bikeKm = :bikeKm")})
public class Bike implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_BIKE", nullable = false)
    private Integer idBIKE;
    @Size(max = 45)
    @Column(name = "BIKE_name", length = 45)
    private String bikeName;
    @Size(max = 45)
    @Column(name = "BIKE_groupe", length = 45)
    private String bikeGroupe;
    @Column(name = "BIKE_km")
    private Integer bikeKm;
    @OneToMany(mappedBy = "tRIPBike")
    private Collection<Trip> tripCollection;
    @JoinColumn(name = "BIKE_User", referencedColumnName = "id_USER")
    @ManyToOne
    private User bIKEUser;

    public Bike() {
    }

    public Bike(Integer idBIKE, String bikeName, String bIKEgroupe, Integer bIKEkm, User bIKEUser) {
        this.idBIKE = idBIKE;
        this.bikeName = bikeName;
        this.bikeGroupe = bIKEgroupe;
        this.bikeKm = bIKEkm;
        this.bIKEUser = bIKEUser;
    }

    public Bike(Integer idBIKE) {
        this.idBIKE = idBIKE;
    }

    public Integer getIdBIKE() {
        return idBIKE;
    }

    public void setIdBIKE(Integer idBIKE) {
        this.idBIKE = idBIKE;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getBIKEgroupe() {
        return bikeGroupe;
    }

    public void setBIKEgroupe(String bIKEgroupe) {
        this.bikeGroupe = bIKEgroupe;
    }

    public Integer getBIKEkm() {
        return bikeKm;
    }

    public void setBIKEkm(Integer bIKEkm) {
        this.bikeKm = bIKEkm;
    }

    @XmlTransient
    public Collection<Trip> getTripCollection() {
        return tripCollection;
    }

    public void setTripCollection(Collection<Trip> tripCollection) {
        this.tripCollection = tripCollection;
    }

    public User getBIKEUser() {
        return bIKEUser;
    }

    public void setBIKEUser(User bIKEUser) {
        this.bIKEUser = bIKEUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBIKE != null ? idBIKE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bike)) {
            return false;
        }
        Bike other = (Bike) object;
        if ((this.idBIKE == null && other.idBIKE != null) || (this.idBIKE != null && !this.idBIKE.equals(other.idBIKE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biketrip.entity.Bike[ idBIKE=" + idBIKE + " ]";
    }
    
}
