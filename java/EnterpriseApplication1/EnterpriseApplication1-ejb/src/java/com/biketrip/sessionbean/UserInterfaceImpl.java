/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biketrip.sessionbean;

import com.biketrip.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author florian
 */
@Stateless
@Remote(UserInterface.class)
public class UserInterfaceImpl implements UserInterface{

    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;
    
    @Override
    public void newUser(String nom) {
        User user = new User();
        user.setUserName(nom);
        
        em.persist(user);  
        
    }
    
    @Override
    public User newUser(User user){
        em.persist(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        Query query = em.createNamedQuery("User.findAll");
        
        List<User> users = query.getResultList();
        return users;

    }

    @Override
    public User getUserById(long id) {
        
        User user = em.find(User.class, id);
        return user;    
    }
    
    public void updateUserPassword(User user) {
        User oldUser = em.find(User.class, user.getIdUSER());
        
        if (oldUser != null) {
        oldUser.setUserPassword(user.getUserPassword());        
        }       
    }
    
    public void updateUserKm(User user, int km) {
        User oldUser = em.find(User.class, user.getIdUSER());
        int oldKm = oldUser.getUserKm();
        
        oldUser.setUserKm(oldKm + km);
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
