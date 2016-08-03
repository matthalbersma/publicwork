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
public class FlooringDAOImplTest {

    public ArrayList<Order> temp = new ArrayList<>();

    public FlooringDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        temp.add(new Order(1, "jones", "MN", 7.5, 100.0, (new Material("wood", 2.0, 2.0))));
        temp.add(new Order(2, "johnson", "IA", 6.5, 200.0, (new Material("granite", 3.0, 3.0))));
        temp.add(new Order(3, "boris", "SD", 5.0, 300, (new Material("nails", 5.0, 5.0))));
        temp.add(new Order(4, "jones", "ND", 6.5, 100, (new Material("coals", 6.0, 1.0))));

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of displayOrders method, of class FlooringDAOImpl.
     */
    @Test
    public void testDisplayOrders() {
        System.out.println("displayOrders");
        String date = "date";
        FlooringDAOImpl instance = new FlooringDAOImpl();
        instance.orders = temp;
        instance.orders.stream().forEach(a -> a.setDate(date));
        ArrayList<Order> result = instance.displayOrders(date);
        assertEquals(result.get(0).getCustName(), "jones");
        assertEquals(result.get(1).getArea(), 200.0, .0001);

    }

    /**
     * Test of addOrder method, of class FlooringDAOImpl.
     */
    @Test
    public void testAddOrder() {
        System.out.println("addOrder");
        Order tempOrder = new Order(4, "rayj", "ND", 6.5, 100, (new Material("coals", 6.0, 1.0)));
        FlooringDAOImpl instance = new FlooringDAOImpl();
        instance.orders = temp;
        instance.addOrder(tempOrder);
        assertEquals(instance.orders.size(), 5);
        assertEquals(instance.orders.get(4).getCustName(), "rayj");

    }

    /**
     * Test of editOrder method, of class FlooringDAOImpl.
     */
    @Test
    public void testEditOrder() {
        System.out.println("editOrder");
        Order tempOrder = new Order(3, "morgan", "SD", 5.0, 300, (new Material("nails", 5.0, 5.0)));
        FlooringDAOImpl instance = new FlooringDAOImpl();
        instance.orders = temp;
        instance.editOrder(tempOrder);
        assertEquals(instance.orders.get(2).getCustName(), "morgan");
        assertTrue(instance.orders.size() == 4);
    }

    /**
     * Test of removeOrder method, of class FlooringDAOImpl.
     */
    @Test
    public void testRemoveOrder() {
        System.out.println("removeOrder");
        int index = 0;
        FlooringDAOImpl instance = new FlooringDAOImpl();
        instance.orders = temp;
        instance.removeOrder(index);
        assertEquals(instance.orders.get(0).getOrderNum(), 2);
        assertTrue(instance.orders.size() == 3);

    }

    /**
     * Test of findOrder method, of class FlooringDAOImpl.
     */
    @Test
    public void testFindOrder() {
        System.out.println("findOrder");
        int orderNum = 1;
        FlooringDAOImpl instance = new FlooringDAOImpl();
        instance.orders = temp;
        Order result = instance.findOrder(orderNum);
        assertEquals(instance.orders.get(0).getCustName(), result.getCustName());
    }

    /**
     * Test of findStateTaxes method, of class FlooringDAOImpl.
     */
    @Test
    public void testFindStateTaxes() {
        System.out.println("findStateTaxes");
        FlooringDAOImpl instance = new FlooringDAOImpl();
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
        FlooringDAOImpl instance = new FlooringDAOImpl();
        ArrayList<Material> result = instance.readMaterial();
        assertEquals(result.get(1).getCostPerSqFt(), 2.25, .01);
    }
}
