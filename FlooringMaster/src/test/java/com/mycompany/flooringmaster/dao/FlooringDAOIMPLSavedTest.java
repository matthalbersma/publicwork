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
import java.util.HashMap;
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
public class FlooringDAOIMPLSavedTest {

    public ArrayList<Order> temp = new ArrayList<>();

    public FlooringDAOIMPLSavedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        FlooringStorage instance = new FlooringStorage();
        temp.add(new Order(2, "johnson", "IA", 6.5, 200.0, (new Material("granite", 3.0, 3.0))));
        temp.add(new Order(3, "boris", "SD", 5.0, 300, (new Material("nails", 5.0, 5.0))));
        temp.add(new Order(4, "jones", "ND", 6.5, 100, (new Material("coals", 6.0, 1.0))));
        temp.get(0).setDate("test");
        temp.get(1).setDate("test");
        temp.get(2).setDate("test");
        instance.writeOrder(temp, "test");

    }

    @After
    public void tearDown() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("Orders_test.txt"));
            out.close();
        } catch (IOException e) {
            System.out.println("Write failed.");
        }
    }

    /**
     * Test of displayOrders method, of class FlooringDAOImpl.
     */
    @Test
    public void testDisplayOrders() {
        System.out.println("displayOrders");
        String date = "test";
        FlooringDAOIMPLSaved instance = new FlooringDAOIMPLSaved();
        ArrayList<Order> result = instance.displayOrders(date);
        assertTrue(result.size() == 3);
        assertEquals(result.get(0).getCustName(), "johnson");

    }

    /**
     * Test of addOrder method, of class FlooringDAOImpl.
     */
    @Test
    public void testAddOrder() {
        System.out.println("addOrder");
        Order tempOrder = new Order(5, "rayj", "ND", 6.5, 100, (new Material("coals", 6.0, 1.0)));
        tempOrder.setDate("test");
        FlooringDAOIMPLSaved instance = new FlooringDAOIMPLSaved();
        instance.orders=instance.displayOrders("test");
        instance.addOrder(tempOrder);
        assertEquals(instance.store.readOrders("Orders_test.txt").size(), 4);

    }

    /**
     * Test of editOrder method, of class FlooringDAOImpl.
     */
    @Test
    public void testEditOrder() {
        System.out.println("editOrder");
        Order tempOrder = new Order(3, "morgan", "SD", 5.0, 300, (new Material("nails", 5.0, 5.0)));
        tempOrder.setDate("test");
        FlooringDAOIMPLSaved instance = new FlooringDAOIMPLSaved();
        instance.orders =instance.displayOrders("test");
        instance.editOrder(tempOrder);
        assertEquals(instance.orders.get(1).getCustName(), "morgan");
        assertTrue(instance.orders.size() == 3);
    }

    /**
     * Test of removeOrder method, of class FlooringDAOImpl.
     */
    @Test
    public void testRemoveOrder() {
        System.out.println("removeOrder");
        int index = 0;
        FlooringDAOIMPLSaved instance = new FlooringDAOIMPLSaved();
        instance.orders = instance.store.readOrders("Orders_test.txt");
        instance.orders.get(0).setDate("test");
        instance.orders.get(1).setDate("test");
        instance.orders.get(2).setDate("test");

        instance.removeOrder(index);
        instance.orders = instance.store.readOrders("Orders_test.txt");
        assertEquals(instance.orders.get(0).getOrderNum(), 3);
        assertTrue(instance.store.readOrders("Orders_test.txt").size() == 2);

    }

    /**
     * Test of findOrder method, of class FlooringDAOImpl.
     */
    @Test
    public void testFindOrder() {
        System.out.println("findOrder");
        int orderNum = 2;
         FlooringDAOIMPLSaved instance = new FlooringDAOIMPLSaved();
        instance.orders = instance.store.readOrders("Orders_test.txt");
        Order result = instance.findOrder(orderNum);
        assertEquals(instance.orders.get(0).getCustName(), result.getCustName());
    }


    /**
     * Test of findStateTaxes method, of class FlooringDAOImpl.
     */
    @Test
    public void testFindStateTaxes() {
        System.out.println("findStateTaxes");
          FlooringDAOIMPLSaved instance = new FlooringDAOIMPLSaved();
        HashMap<String, Double> result = instance.findStateTaxes();
        assertEquals(result.get("MN"), 6.875, .001);
        assertEquals(result.keySet().size(), 5);
    }

    /**
     * Test of readMaterial method, of class FlooringDAOImpl.
     */
    @Test
    public void testReadMaterial() {
        System.out.println("readMaterial");
          FlooringDAOIMPLSaved instance = new FlooringDAOIMPLSaved();
        ArrayList<Material> result = instance.readMaterial();
        assertEquals(result.get(1).getCostPerSqFt(), 2.25, .01);
    }




}
