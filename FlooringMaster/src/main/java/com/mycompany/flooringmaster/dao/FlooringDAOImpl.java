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
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class FlooringDAOImpl implements FlooringDAO{
    Reader reader=new Reader();
    ArrayList<Order> orders=new ArrayList<>();
    
    //returns arraylist based on date submitted.
    @Override
    public ArrayList<Order> displayOrders(String date){
        return new ArrayList(orders.stream().filter(a->a.getDate().equals(date)).collect(Collectors.toList()));
    }
    @Override
    public void addOrder(Order tempOrder){
        orders.add(tempOrder);
    }
    @Override
    public void editOrder(Order tempOrder){
        for (int i=0; i<orders.size(); i++){
            if (orders.get(i).getOrderNum()==tempOrder.getOrderNum()){
                orders.set(i, tempOrder);
            }
        }
    }
    @Override
    public void removeOrder(int position){
        //Catch Exceptions here. Although input blocked.
        if(orders.contains(orders.get(position))){
        orders.remove(position);}
    }
    @Override
    public Order findOrder(int orderNum){
       List<Order> temp=orders.stream().filter(a->a.getOrderNum()==orderNum).collect(Collectors.toList());
       return temp.get(0);
    }
    @Override
    public HashMap<String, Double> findStateTaxes(){
        return new HashMap<>(reader.readTaxRate());
    }
    @Override
    public ArrayList<Material> readMaterial(){
        return new ArrayList(reader.readMaterial());
    }
}