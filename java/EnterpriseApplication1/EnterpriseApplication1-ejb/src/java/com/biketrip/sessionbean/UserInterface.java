/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biketrip.sessionbean;

import com.biketrip.entity.User;
import java.util.List;

/**
 *
 * @author florian
 */
public interface UserInterface {
    
    public void newUser(String nom);
    public User newUser(User user);
    public List<User> getAllUser();
    public User getUserById(long id);
}
