/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma;

import com.matthalbersma.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

/**
 * @author walter
 */
@Controller
public class LoginController {
    @Autowired
    private ItemRepository repo;

    @RequestMapping(value = "/administrate")
//    @ResponseBody
    public String getAdmin() {
        return "administrate";

    }

    @RequestMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@Valid @RequestBody Item item) {
        repo.save(item);
    }

}
