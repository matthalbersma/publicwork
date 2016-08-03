/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dao;

import com.mycompany.flooringmaster.dto.Material;
import com.mycompany.flooringmaster.dto.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class FlooringStorageTest {

    public FlooringStorageTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
           try {
            PrintWriter out = new PrintWriter(new FileWriter("test.txt"));
            out.close();
        } catch (IOException e) {
            System.out.println("Write failed.");
        }
    
    }

    /**
     * Test of readOrders method, of class FlooringStorage.
     */
    @Test
    public void testReadWriteOrders() {
        System.out.println("readWriteOrders");
        String filename = "Orders_test1.txt";
        FlooringStorage instance = new FlooringStorage();
        ArrayList<Order> temp = new ArrayList<>();
        temp.add(new Order(2, "johnson", "IA", 6.5, 200.0, (new Material("granite", 3.0, 3.0))));
        temp.add(new Order(3, "boris", "SD", 5.0, 300, (new Material("nails", 5.0, 5.0))));
        temp.add(new Order(4, "jones", "ND", 6.5, 100, (new Material("coals", 6.0, 1.0))));
        
        instance.writeOrder(temp, "test1");
        ArrayList<Order> result = instance.readOrders(filename);
        assertEquals(result.get(0).getCustName(), "johnson");
        assertEquals(result.get(2).getState(),"ND");
       
    }

}
