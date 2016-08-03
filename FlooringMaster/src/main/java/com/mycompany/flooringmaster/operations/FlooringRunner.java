/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.operations;

import com.mycompany.flooringmaster.dao.Reader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Matt Halbersma
 */
public class FlooringRunner {

    Reader read = new Reader();
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args) {
        new FlooringRunner().testorprod();

    }

    public void testorprod() {
        if (read.testOrProd().equals("prod")) {
            FlooringController a = (FlooringController) ctx.getBean("controlprod");
            a.ui();
        } else if (read.testOrProd().equals("test")) {
            FlooringController a = (FlooringController) ctx.getBean("control");
            a.ui();
        }

    }
}
