/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.InterestCalculatorDTO;
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

public class InterestCalcController {

    @RequestMapping(value = "/interestcalc", method = RequestMethod.GET)
    public String displayInterestCalc() {
        return "interestcalc";

    }

    @RequestMapping(value = "/interestcalc", method = RequestMethod.POST)
    public String postInterestCalc(HttpServletRequest request, Model model) {
        String rate = request.getParameter("interest");
        String principal = request.getParameter("principal");
        String years = request.getParameter("years");
        String compound = request.getParameter("compound");
        InterestCalculatorDTO a = new InterestCalculatorDTO();
        a.setCompound(Integer.parseInt(compound));
        a.setInterest(Double.parseDouble(rate));
        a.setPrincipal(Double.parseDouble(principal));
        a.setYears(Integer.parseInt(years));
        new InterestCalculatorMethods().interest(a);
        model.addAttribute("results", a);
        return "icresponse";
    }
}
