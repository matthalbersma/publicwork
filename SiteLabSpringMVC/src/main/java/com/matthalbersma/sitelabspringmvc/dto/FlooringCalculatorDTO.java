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
public class FlooringCalculatorDTO {
    private int width;
    private int length;
    private int perSqFT;
    private double productCost;
    private double total;
    private double laborCost;

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the perSqFT
     */
    public int getPerSqFT() {
        return perSqFT;
    }

    /**
     * @param perSqFT the perSqFT to set
     */
    public void setPerSqFT(int perSqFT) {
        this.perSqFT = perSqFT;
    }

    /**
     * @return the productCost
     */
    public double getProductCost() {
        return productCost;
    }

    /**
     * @param productCost the productCost to set
     */
    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the laborCost
     */
    public double getLaborCost() {
        return laborCost;
    }

    /**
     * @param laborCost the laborCost to set
     */
    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }
}
