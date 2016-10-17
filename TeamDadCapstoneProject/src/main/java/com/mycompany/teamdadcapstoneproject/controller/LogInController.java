
package com.mycompany.teamdadcapstoneproject.controller;

/**
 *
 * @author Matthew Halbersma
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
