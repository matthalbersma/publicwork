/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.FactorizorDTO;

/**
 *
 * @author apprentice
 */
public class FactorizorMethods {

    public void factorizor(FactorizorDTO a) {
        int  factorCounter = 0, perfect = 0;
        a.setFactors("");
        for (int i = 1; i < a.getInNumber(); i++) {
            if ((a.getInNumber() % i) == 0) {
                factorCounter++;
                perfect += i;
                if (i==1){a.setFactors((a.getFactors())+i);}
                else {a.setFactors((a.getFactors())+","+i);}
            }
        }
        a.setNumFactors(factorCounter);
        if (perfect == a.getInNumber()) {
            a.setPerfect(a.getInNumber() + " is a perfect number");
        } else {
            a.setPerfect(a.getInNumber() + " is not a perfect number");
        }
        if (factorCounter == 1) {
            a.setPrime(a.getInNumber() + " is a prime number");
        } else {
            a.setPrime(a.getInNumber() + " is not a prime number");
        }
    }

}
