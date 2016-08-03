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
public class TipCalculatorDTO {
    private Double amount;
    private Double percentage;
    private Double tip;
    private Double total;

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the percentage
     */
    public Double getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    /**
     * @return the tip
     */
    public Double getTip() {
        return tip;
    }

    /**
     * @param tip the tip to set
     */
    public void setTip(Double tip) {
        this.tip = tip;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

}
