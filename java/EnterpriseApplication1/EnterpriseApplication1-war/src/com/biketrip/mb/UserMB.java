/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biketrip.mb;

import com.biketrip.entity.User;
import com.biketrip.sessionbean.UserInterfaceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author florian
 */
@Named(value = "user")
@RequestScoped 
public class UserMB {
    
    @EJB
    private UserInterfaceImpl userSB;
    private User user = new User();
    private List<User> users = new ArrayList<>();
    
    public void addNewUser() {
        user = userSB.newUser(user);
    }

}
