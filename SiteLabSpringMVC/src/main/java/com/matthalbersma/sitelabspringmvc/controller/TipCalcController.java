/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.TipCalculatorDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Matthew Halbersma
 */
@Controller
public class TipCalcController {
    
    @RequestMapping (value="/tipcalc", method=RequestMethod.GET)
    public String displayTipCalc(){
        return "tipcalc";
    }
    @RequestMapping (value="/tipcalc", method=RequestMethod.POST)
    public String displayResults(HttpServletRequest req, Model model) {
        String amount=req.getParameter("amount");
        String percentage=req.getParameter("percentage");
        TipCalculatorDTO a=new TipCalculatorDTO();
        a.setAmount(Double.parseDouble(amount));
        a.setPercentage(Double.parseDouble(percentage));
        new TipCalculatorMethods().run(a);
        model.addAttribute("results",a);
        return "tcresponse";
        
    }

}
