/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.UnitConverterDTO;
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
public class ConverterController {
    @RequestMapping(value = "/converter", method = RequestMethod.GET)
    public String displayConverter() {
        return "converter";
    }
          @RequestMapping(value="/converter", method=RequestMethod.POST)
   public String postFactorizor(HttpServletRequest request, Model model) {
       String unit1= request.getParameter("unit1");
         String unit2= request.getParameter("unit2");
         String convert1=request.getParameter("convert1");
         UnitConverterDTO a=new UnitConverterDTO ();
         a.setUnit1(unit1);
         a.setUnit2(unit2);
         a.setConvert1(Double.parseDouble(convert1));
         new ConverterMethods().run(a);
         model.addAttribute("results", a);
         return "cresponse";
         

   
   }
}
