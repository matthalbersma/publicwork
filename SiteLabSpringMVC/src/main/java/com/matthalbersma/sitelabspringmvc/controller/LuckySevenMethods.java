/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.LuckySevens;
import java.util.Random;

/**
 *
 * @author Matthew Halbersma
 */
public class LuckySevenMethods {

    int diceRoll1, diceRoll2, totalRoll, currentBet = 0;
   

    public void sevens(LuckySevens h) {

        currentBet = h.getBet();
        while (currentBet > 0) {
            counter(h);
        }
      
    }

    private boolean diceRoller() {
        Random diceRoll = new Random();
        diceRoll1 = diceRoll.nextInt(6) + 1;
        diceRoll2 = diceRoll.nextInt(6) + 1;
        totalRoll = diceRoll1 + diceRoll2;
        return totalRoll == 7;
    }

    private void maxTracker(LuckySevens h) {
        if (currentBet >= h.getMaxMoney()) {
            h.setMaxMoney(currentBet);
            h.setCountOnMax(h.getRollCount());
        }
    }

    private void counter(LuckySevens h) {
        if (diceRoller()) {
            h.setRollCount(h.getRollCount()+1);
            currentBet += 4;
            maxTracker(h);
        } else {
            maxTracker(h);
            h.setRollCount(h.getRollCount()+1);
            currentBet -= 1;
        }
    }

}
