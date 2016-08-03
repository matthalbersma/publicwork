/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.FactorizorDTO;
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
public class FactorizorController {

   @RequestMapping(value="/factorizor", method=RequestMethod.GET)
   public String displayFactorizor() {
       return "factorizor";
   } 
   @RequestMapping(value="/factorizor", method=RequestMethod.POST)
   public String postFactorizor(HttpServletRequest request, Model model) {
       String answer= request.getParameter("inNumber");
       FactorizorDTO a=new FactorizorDTO();
       a.setInNumber(Integer.parseInt(answer));
       new FactorizorMethods().factorizor(a);
       model.addAttribute("results", a);
       return "factresponse";
   
   }
}
