/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teamdadcapstoneproject.controller;

/**
 *
 * @author apprentice
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class LogInController {

 @RequestMapping(value={"/login", "/admin"}, method = RequestMethod.GET)
 public String showLoginForm() {
 return "login";
 }
}
