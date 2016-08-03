/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import com.mycompany.flooringmaster.dto.Material;
import com.mycompany.flooringmaster.dto.Order;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public interface FlooringDAO {
     public ArrayList<Order> displayOrders(String date);
     public void addOrder(Order tempOrder);
     public void editOrder(Order tempOrder);
     public void removeOrder(int index);
     public Order findOrder(int orderNum);
     public ArrayList<Material> readMaterial();
     public HashMap<String,Double> findStateTaxes();
}
