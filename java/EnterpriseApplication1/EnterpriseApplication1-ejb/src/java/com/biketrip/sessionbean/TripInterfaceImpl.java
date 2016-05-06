/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biketrip.sessionbean;

import com.biketrip.entity.Trip;
import java.sql.Date;
import java.time.LocalDate;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author florian
 */
@Stateless
@Remote(TripInterface.class)
public class TripInterfaceImpl implements TripInterface{
    
    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;
    
    @Override
    public long createTrip(String nom) {
        Trip trip = new Trip();
        trip.setTRIPDate(Date.valueOf(LocalDate.now()));
        
        em.persist(trip);
        
        return trip.getIdTRIP();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
