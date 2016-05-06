/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biketrip.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author florian
 */
@Entity
@Table(name = "BIKE_TRIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t"),
    @NamedQuery(name = "Trip.findByIdTRIP", query = "SELECT t FROM Trip t WHERE t.idTRIP = :idTRIP"),
    @NamedQuery(name = "Trip.findByTRIPDate", query = "SELECT t FROM Trip t WHERE t.tRIPDate = :tRIPDate"),
    @NamedQuery(name = "Trip.findByTripKm", query = "SELECT t FROM Trip t WHERE t.tripKm = :tripKm"),
    @NamedQuery(name = "Trip.findByTRIPTime", query = "SELECT t FROM Trip t WHERE t.tRIPTime = :tRIPTime"),
    @NamedQuery(name = "Trip.findByTRIPSpeed", query = "SELECT t FROM Trip t WHERE t.tRIPSpeed = :tRIPSpeed"),
    @NamedQuery(name = "Trip.findByTRIPDenivele", query = "SELECT t FROM Trip t WHERE t.tRIPDenivele = :tRIPDenivele")})
public class Trip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_TRIP", nullable = false)
    private Integer idTRIP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRIP_Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tRIPDate;
    @Size(max = 45)
    @Column(name = "TRIP_KM", length = 45)
    private String tripKm;
    @Size(max = 45)
    @Column(name = "TRIP_Time", length = 45)
    private String tRIPTime;
    @Size(max = 45)
    @Column(name = "TRIP_Speed", length = 45)
    private String tRIPSpeed;
    @Size(max = 45)
    @Column(name = "TRIP_Denivele", length = 45)
    private String tRIPDenivele;
    @JoinColumn(name = "TRIP_Bike", referencedColumnName = "id_BIKE")
    @ManyToOne
    private Bike tRIPBike;
    
    public Trip() {
    }

    public Trip(Integer idTRIP) {
        this.idTRIP = idTRIP;
    }

    public Trip(Integer idTRIP, Date tRIPDate) {
        this.idTRIP = idTRIP;
        this.tRIPDate = tRIPDate;
    }

    public Integer getIdTRIP() {
        return idTRIP;
    }

    public void setIdTRIP(Integer idTRIP) {
        this.idTRIP = idTRIP;
    }

    public Date getTRIPDate() {
        return tRIPDate;
    }

    public void setTRIPDate(Date tRIPDate) {
        this.tRIPDate = tRIPDate;
    }

    public String getTripKm() {
        return tripKm;
    }

    public void setTripKm(String tripKm) {
        this.tripKm = tripKm;
    }

    public String getTRIPTime() {
        return tRIPTime;
    }

    public void setTRIPTime(String tRIPTime) {
        this.tRIPTime = tRIPTime;
    }

    public String getTRIPSpeed() {
        return tRIPSpeed;
    }

    public void setTRIPSpeed(String tRIPSpeed) {
        this.tRIPSpeed = tRIPSpeed;
    }

    public String getTRIPDenivele() {
        return tRIPDenivele;
    }

    public void setTRIPDenivele(String tRIPDenivele) {
        this.tRIPDenivele = tRIPDenivele;
    }

    public Bike getTRIPBike() {
        return tRIPBike;
    }

    public void setTRIPBike(Bike tRIPBike) {
        this.tRIPBike = tRIPBike;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTRIP != null ? idTRIP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trip)) {
            return false;
        }
        Trip other = (Trip) object;
        if ((this.idTRIP == null && other.idTRIP != null) || (this.idTRIP != null && !this.idTRIP.equals(other.idTRIP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biketrip.entity.Trip[ idTRIP=" + idTRIP + " ]";
    }
    
}
