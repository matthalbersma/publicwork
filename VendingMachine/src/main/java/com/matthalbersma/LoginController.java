/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author walter
 */
@Controller
public class LoginController {
    
    @RequestMapping(value="/administrate")
//    @ResponseBody
    public String getAdmin() {
        return "administrate";
                
    }
    @RequestMapping(value="/login")
    public String getLoginPage() {
        return "login";
    }
    @RequestMapping(value="/")
    public String getIndex(){
        return "index";
    }
    
}
