/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.FlooringCalculatorDTO;
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
public class FlooringCalcController {
    @RequestMapping (value="/flooringcalc", method=RequestMethod.GET)
    public String displayFlooring() {
        return "flooringcalc";
    }
    @RequestMapping (value="/flooringcalc", method=RequestMethod.POST)
    public String displayResults(HttpServletRequest req, Model model){
        String width=req.getParameter("width");
        String length=req.getParameter("length");
        String perSqFt=req.getParameter("perSqFt");
        FlooringCalculatorDTO a=new FlooringCalculatorDTO();
        a.setLength(Integer.parseInt(length));
        a.setWidth(Integer.parseInt(width));
        a.setPerSqFT(Integer.parseInt(perSqFt));
        new FlooringCalculatorMethods().run(a);
        model.addAttribute("results",a);
        return "fcresponse";
        
    }
}
