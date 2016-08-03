/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import com.mycompany.flooringmaster.dto.Material;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Reader {

    public ArrayList<Material> readMaterial() {
        ArrayList<Material> a = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("material.txt")));
            String temp;
            String[] tempStrings;

            while (sc.hasNextLine()) {
                temp = sc.nextLine();
                tempStrings = temp.split("::");
                a.add(new Material(tempStrings[0], Double.parseDouble(tempStrings[1]), Double.parseDouble(tempStrings[2])));
            }
        } catch (FileNotFoundException e) {
            //No relevant action to be performed
        }

        return a;

    }

    public HashMap<String, Double> readTaxRate() {

        HashMap<String, Double> b = new HashMap<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("tax.txt")));
            String temp;
            String[] tempStrings;

            while (sc.hasNextLine()) {
                temp = sc.nextLine();
                tempStrings = temp.split("::");
                b.put(tempStrings[0], Double.parseDouble(tempStrings[1]));
            }
        } catch (FileNotFoundException e) {
            //No relevant action to be performed
        }
        return b;

    }
    public String testOrProd(){
        String a=null;
        try{
            
            Scanner sc = new Scanner(new BufferedReader(new FileReader("testorprod.txt")));
           while (sc.hasNextLine()){ a=sc.nextLine();}
        }
    catch (FileNotFoundException e) {
            //No relevant action to be performed
        }
    return a;
}
}
