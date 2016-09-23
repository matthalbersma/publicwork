/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma;

import com.matthalbersma.model.Change;
import com.matthalbersma.model.InputDollars;
import com.matthalbersma.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="vend/{id}", method=RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)

    public String returnChange(@PathVariable("id") String id, @Valid  @RequestBody InputDollars dollars){
        Item temp=repo.findOne(id);
        System.out.println(temp);
        temp.setStock(temp.getStock()-1);
        Double changeIt=dollars.getDollars()-temp.getCost();
        repo.save(temp);

        return new Change((int) (changeIt*100)).toString();
       // return "jimmy";

    }

}
