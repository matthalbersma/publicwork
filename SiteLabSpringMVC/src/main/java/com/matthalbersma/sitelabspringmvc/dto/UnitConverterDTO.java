/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matthalbersma.sitelabspringmvc.dto;

/**
 *
 * @author Matthew Halbersma
 */
public class UnitConverterDTO {
    private String unit1;
    private String unit2;
    private double convert, convert1;

    /**
     * @return the unit1
     */
    public String getUnit1() {
        return unit1;
    }

    /**
     * @param unit1 the unit1 to set
     */
    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    /**
     * @return the unit2
     */
    public String getUnit2() {
        return unit2;
    }

    /**
     * @param unit2 the unit2 to set
     */
    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    /**
     * @return the convert
     */
    public double getConvert() {
        return convert;
    }

    /**
     * @param convert the convert to set
     */
    public void setConvert(double convert) {
        this.convert = convert;
    }

    /**
     * @return the convert1
     */
    public double getConvert1() {
        return convert1;
    }

    /**
     * @param convert1 the convert1 to set
     */
    public void setConvert1(double convert1) {
        this.convert1 = convert1;
    }

}
