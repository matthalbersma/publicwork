/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma.dvdlibraryspringmvc.dao;

import com.matthalbersma.dvdlibraryspringmvc.dto.DVD;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DvdLibrary {
    
    public void addDvd(DVD dvd);
    public void removeDvd(int id);
    public void editDvd(DVD dvd);
    public ArrayList<DVD> getAll();
    public DVD getByID(int id);
    public List<DVD> searchList(Map<SearchType, String> crit);
    
}
