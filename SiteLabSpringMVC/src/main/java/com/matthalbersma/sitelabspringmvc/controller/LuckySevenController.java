/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matthalbersma.sitelabspringmvc.controller;

import com.matthalbersma.sitelabspringmvc.dto.LuckySevens;
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
public class LuckySevenController {
   @RequestMapping(value="/luckyseven", method=RequestMethod.GET)
   public String displayLuckySeven() {
       return "luckyseven";
   } 
   @RequestMapping(value="/luckyseven", method=RequestMethod.POST)
   public String postLuckySeven(HttpServletRequest request, Model model) {
       String answer= request.getParameter("bet");
       LuckySevens a=new LuckySevens();
       a.setBet(Integer.parseInt(answer));
       new LuckySevenMethods().sevens(a);
       model.addAttribute("results", a);
       return "lsresponse";
   
   }
   

}
