/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.TipCalculatorDTO;

/**
 *
 * @author Matthew Halbersma
 */
public class TipCalculatorMethods {
    public void run(TipCalculatorDTO a){
        double value=a.getAmount()*(a.getPercentage()/100);
        value=Math.round(value*100);
        a.setTip(value/100);
        value=a.getAmount()+a.getTip();
        value=Math.round(value*100);
        a.setTotal(value/100);
    }

}
