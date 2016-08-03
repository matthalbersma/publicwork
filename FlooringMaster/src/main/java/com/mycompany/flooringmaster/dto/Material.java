/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmaster.dto;

/**
 *
 * @author apprentice
 */
public class Material {
    private String productType;
    private double costPerSqFt;
    private double laborPerSqFt;
    
    public Material (String productType, double costPerSqFt, double laborPerSqFt){
        this.productType=productType;
        this.costPerSqFt=costPerSqFt;
        this.laborPerSqFt=laborPerSqFt;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the costPerSqFt
     */
    public double getCostPerSqFt() {
        return costPerSqFt;
    }

    /**
     * @param costPerSqFt the costPerSqFt to set
     */
    public void setCostPerSqFt(double costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    /**
     * @return the laborPerSqFt
     */
    public double getLaborPerSqFt() {
        return laborPerSqFt;
    }

    /**
     * @param laborPerSqFt the laborPerSqFt to set
     */
    public void setLaborPerSqFt(double laborPerSqFt) {
        this.laborPerSqFt = laborPerSqFt;
    }
    
}
