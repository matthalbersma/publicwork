/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import com.mycompany.flooringmaster.dto.Material;
import com.mycompany.flooringmaster.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringStorage {
  

    public ArrayList<Order> readOrders(String filename) {
        ArrayList<Order> a = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
            String temp;
            String[] tempStrings;

            while (sc.hasNextLine()) {
                temp = sc.nextLine();
                tempStrings = temp.split("::");
                a.add(new Order(Integer.parseInt(tempStrings[0]), tempStrings[1], tempStrings[2], Double.parseDouble(tempStrings[3]), Double.parseDouble(tempStrings[4]),
                        (new Material(tempStrings[5], Double.parseDouble(tempStrings[6]), Double.parseDouble(tempStrings[7])))));
            }
        } catch (FileNotFoundException e) {
            //No relevant action to be performed
        }

        return a;
    }
    public void writeOrder(ArrayList<Order> a, String date){
        try {
            date="Orders_"+date+".txt";
            PrintWriter out = new PrintWriter(new FileWriter(date));
            for (Order i : a) {
                out.println(i.getOrderNum()
                        + "::" + i.getCustName()
                        + "::" + i.getState()
                        +"::"+i.getTaxRate()
                        +"::"+i.getArea()
                        +"::"+i.getMaterialType().getProductType()
                        +"::"+i.getMaterialType().getCostPerSqFt()
                        +"::"+i.getMaterialType().getLaborPerSqFt()
                        +"::"+i.calcMatCost(i)
                        +"::"+i.calcLabCost(i)
                        +"::"+i.calcTax(i)
                        +"::"+i.calcTotal(i));
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println("Write failed.");
        }

    }
}
