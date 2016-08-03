/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.UnitConverterDTO;

/**
 *
 * @author Matthew Halbersma
 */
public class ConverterMethods {
    public void run(UnitConverterDTO a){
        double unit=a.getConvert1();
        switch (a.getUnit1()){
            
            case "Fahrenheit":
                if (a.getUnit2().equals("Kelvin")) a.setConvert ((unit+459.67)*(5/9));
                else{ a.setConvert((unit-32)*(5/9));}
                break;
            case "Kelvin":
                if (a.getUnit2().equals("Celsius")) a.setConvert(unit-273.15);
                else {a.setConvert((unit*(9/5))-459.67);}
                break;
            case "Celsius":
                if (a.getUnit2().equals("Fahrenheit")) a.setConvert((unit*(9/5))+32);
                else {a.setConvert(unit+273.15);}
                break;
            case "KG":
                a.setConvert(unit/.4536);
                break;
            case "LBS":
                a.setConvert(unit*.4536);
                break;
               
            case "Gallon":
                a.setConvert(unit/.26417);
                break;
                
            case "Liter":
                a.setConvert(unit*.26417);
                break;
        }
    }
}
