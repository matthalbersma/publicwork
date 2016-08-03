/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.InterestCalculatorDTO;

/**
 *
 * @author apprentice
 */
public class InterestCalculatorMethods {

    public void interest(InterestCalculatorDTO a) {
        int  denom;
        double  yearStart, yearEnd;
        switch (a.getCompound()) {
            case 1:
                denom = 365;
                break;
            case 2:
                denom = 12;
                break;
            case 3:
                denom = 4;
                break;
            default:
                System.out.println("You entered an invalid value: Goodbye!");
                return;
        }
        a.setOutput("");
        for (int i = 1; i <= a.getYears(); i++) {
            yearStart = a.getPrincipal();
            for (int j = 1; j <= denom; j++) {
                a.setPrincipal( a.getPrincipal() * (1 + (a.getInterest() / (denom * 100))));
            }
            yearEnd = a.getPrincipal() - yearStart;
            a.setOutput(a.getOutput()+("<br><b>Year " + i + ":</b>  Principal at beginning of year: $" + Math.round(yearStart * 100.0) / 100.0 + "<br>"
                    + "Interest earned this year: $" + Math.round(yearEnd * 100.0) / 100.0 + " Principal at end of year: $" + Math.round(a.getPrincipal() * 100.0) / 100.0)+"<br>");

        }
    }

}
