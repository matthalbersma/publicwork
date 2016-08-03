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
public class FactorizorDTO {
    private int inNumber;
    private String perfect;
    private String prime;
    private int numFactors;
    private String factors;

    /**
     * @return the inNumber
     */
    public int getInNumber() {
        return inNumber;
    }

    /**
     * @param inNumber the inNumber to set
     */
    public void setInNumber(int inNumber) {
        this.inNumber = inNumber;
    }

    /**
     * @return the perfect
     */
    public String getPerfect() {
        return perfect;
    }

    /**
     * @param perfect the perfect to set
     */
    public void setPerfect(String perfect) {
        this.perfect = perfect;
    }

    /**
     * @return the prime
     */
    public String getPrime() {
        return prime;
    }

    /**
     * @param prime the prime to set
     */
    public void setPrime(String prime) {
        this.prime = prime;
    }

    /**
     * @return the numFactors
     */
    public int getNumFactors() {
        return numFactors;
    }

    /**
     * @param numFactors the numFactors to set
     */
    public void setNumFactors(int numFactors) {
        this.numFactors = numFactors;
    }

    /**
     * @return the factors
     */
    public String getFactors() {
        return factors;
    }

    /**
     * @param factors the factors to set
     */
    public void setFactors(String factors) {
        this.factors = factors;
    }



}
