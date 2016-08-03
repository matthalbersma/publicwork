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
public class FlooringDAOIMPLSaved implements FlooringDAO {

    Reader reader = new Reader();
    ArrayList<Order> orders = new ArrayList<>();
    FlooringStorage store = new FlooringStorage();

//This reads orders from .txt file and loads them into orders ArrayList.
    @Override
    public ArrayList<Order> displayOrders(String date) {
        String date1 = "Orders_" + date + ".txt";
        ArrayList<Order> thisone = store.readOrders(date1);
        thisone.stream().forEach(a -> a.setDate(date));
        orders=thisone;

        return new ArrayList<>(orders);
    }

    @Override
    public void addOrder(Order tempOrder) {
       orders.add(tempOrder);
        store.writeOrder(orders, tempOrder.getDate());
    }

    @Override
    public void editOrder(Order tempOrder) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNum() == tempOrder.getOrderNum()) {
                orders.set(i, tempOrder);

            }
        }
        store.writeOrder(orders, tempOrder.getDate());
    }

    @Override
    public void removeOrder(int position) {
                //Catch Exceptions here. Although input blocked.
        if(orders.contains(orders.get(position))){
        String date=orders.get(position).getDate();
        orders.remove(position);
        store.writeOrder(orders,date);
    }
    }

    @Override
    public Order findOrder(int orderNum) {
        List<Order> temp = orders.stream().filter(a -> a.getOrderNum() == orderNum).collect(Collectors.toList());
        return temp.get(0);
    }

    public HashMap<String, Double> findStateTaxes() {
        return new HashMap<>(reader.readTaxRate());
    }

    public ArrayList<Material> readMaterial() {
        return new ArrayList(reader.readMaterial());
    }
}
