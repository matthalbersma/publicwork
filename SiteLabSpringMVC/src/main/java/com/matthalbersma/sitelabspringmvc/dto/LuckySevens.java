/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma.sitelabspringmvc.dto;

/**
 *
 * @author apprentice
 */
public class LuckySevens {
    public int bet;
    private int countOnMax=0;
    private int rollCount=0;
    private int maxMoney=0;


    /**
     * @return the countOnMax
     */
    public int getCountOnMax() {
        return countOnMax;
    }

    /**
     * @param countOnMax the countOnMax to set
     */
    public void setCountOnMax(int countOnMax) {
        this.countOnMax = countOnMax;
    }

    /**
     * @return the rollCount
     */
    public int getRollCount() {
        return rollCount;
    }

    /**
     * @param rollCount the rollCount to set
     */
    public void setRollCount(int rollCount) {
        this.rollCount = rollCount;
    }

    /**
     * @return the maxMoney
     */
    public int getMaxMoney() {
        return maxMoney;
    }

    /**
     * @param maxMoney the maxMoney to set
     */
    public void setMaxMoney(int maxMoney) {
        this.maxMoney = maxMoney;
    }

    /**
     * @return the bet
     */
    public int getBet() {
        return bet;
    }

    /**
     * @param bet the bet to set
     */
    public void setBet(int bet) {
        this.bet = bet;
    }











}


