/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biketrip.sessionbean;

import com.biketrip.entity.Bike;
import com.biketrip.entity.User;
import java.util.List;

/**
 *
 * @author florian
 */
public interface BikeInterface {
    
    public void newBike(User user, String name);
    public List<Bike> getBikesByUser(User user);
    public Bike getBikeById();
    
}
