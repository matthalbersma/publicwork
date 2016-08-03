/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.FlooringCalculatorDTO;

/**
 *
 * @author Matthew Halbersma
 */
public class FlooringCalculatorMethods {

    public void run(FlooringCalculatorDTO a) {
        double cost15 = 21.5;
        double area;
        int num15;
        area = a.getLength() * a.getWidth();
        a.setProductCost(area * a.getPerSqFT());
        if (area % 5 != 0) {
            num15 = ((int) Math.floor(area / 5) + 1);
        } else {
            num15 = (int) area / 5;
        }
        a.setLaborCost(num15*cost15);
        a.setTotal((num15 * cost15) + a.getProductCost());
    }
}
