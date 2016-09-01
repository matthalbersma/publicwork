/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma.dvdlibraryspringmvc.controller;

import com.matthalbersma.dvdlibraryspringmvc.dao.DvdLibrary;
import com.matthalbersma.dvdlibraryspringmvc.dao.SearchType;
import com.matthalbersma.dvdlibraryspringmvc.dto.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Matthew Halbersma
 */
@Controller
public class HomeController {

    private DvdLibrary dao;

@Inject 
    public HomeController(DvdLibrary dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/dvdlist"}, method = RequestMethod.GET)
    public String displayHome() {
        return "dvdlist";
    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DVD getDVD(@PathVariable("id") int id) {
        return dao.getByID(id);
    }

    @RequestMapping(value = "/adddvd", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DVD adddvd(@RequestBody DVD dvd) {
        if (dvd.getCoverURL().isEmpty()){
            dvd.setCoverURL("/DvdLibrarySpringMVC//img/blank.jpg");
        }
        dao.addDvd(dvd);
        return dvd;
    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDVD(@PathVariable("id") int id) {
        dao.removeDvd(id);

    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putEdit(@PathVariable("id") int id, @RequestBody DVD dvd) {
        dvd.setId(id);
        dao.editDvd(dvd);
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchPage() {
        return "search";
    }

    @RequestMapping(value = "/searchresults", method = RequestMethod.POST)
    @ResponseBody
    public List<DVD> searchDVD(@RequestBody Map<String, String> searchMap) {
        Map<SearchType, String> crit = new HashMap<>();
        String term = searchMap.get("title");
        if (!term.isEmpty()) {
            crit.put(SearchType.TITLE, term);
        }
        term = searchMap.get("imdbID");
        if (!term.isEmpty()) {
            crit.put(SearchType.IMDBID, term);
        }
        term = searchMap.get("releaseDate");
        if (!term.isEmpty()) {
            crit.put(SearchType.RELEASEDATE, term);
        }
        term = searchMap.get("mpaaRating");
        if (!term.isEmpty()) {
            crit.put(SearchType.MPAA, term);
        }
        term=searchMap.get("director");
            if(!term.isEmpty()){
             crit.put(SearchType.DIRECTOR, term);
        }
      return dao.searchList(crit);
    }

    @RequestMapping(value = "/dvds", method = RequestMethod.GET)
    @ResponseBody
    public List<DVD> getDVDs() {
        return dao.getAll();
    }

}
