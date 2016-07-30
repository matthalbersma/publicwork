/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matthalbersma.dvdlibraryspringmvc.dao;

import com.matthalbersma.dvdlibraryspringmvc.dto.DVD;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Matthew Halbersma
 */
public class DvdLibraryInMemIMPL implements DvdLibrary {
    private Map<Integer, DVD> dvdMap=new HashMap<>();
    private static int counter=0;

    @Override
    public void addDvd(DVD dvd) {
        dvd.setId(counter);
        counter++;
        dvdMap.put(dvd.getId(), dvd);     
    }

    @Override
    public void removeDvd(int id) {
       dvdMap.remove(id);
    }

    @Override
    public void editDvd(DVD dvd) {
        dvdMap.put(dvd.getId(),dvd);
    }

    @Override
    public ArrayList<DVD> getAll() {
        Collection<DVD> collect=dvdMap.values();
        return new ArrayList<DVD>(collect);
    }

    @Override
    public DVD getByID(int id) {
        return dvdMap.get(id);
    }

    @Override
    public List<DVD> searchList(Map<SearchType, String> crit) {
        String titleCrit=crit.get(SearchType.TITLE);
        String imdbCrit=crit.get(SearchType.IMDBID);
        String mpaaCrit=crit.get(SearchType.MPAA);
        String direcCrit=crit.get(SearchType.DIRECTOR);
        String releaseCrit=crit.get(SearchType.RELEASEDATE);
        
        Predicate<DVD> titleMatch;
        Predicate<DVD> imdbMatch;
        Predicate<DVD> mpaaMatch;
        Predicate<DVD> directMatch;
        Predicate<DVD> releaseMatch;
        Predicate<DVD> truePred=(c)->{return true;};
        
        titleMatch=(titleCrit==null||titleCrit.isEmpty())
                ?truePred
                :(c)->c.getTitle().equalsIgnoreCase(titleCrit);
        imdbMatch=(imdbCrit==null||imdbCrit.isEmpty())
                ?truePred
                :(c)->c.getImdbID().equals(imdbCrit);
        mpaaMatch=(mpaaCrit==null||mpaaCrit.isEmpty())
                ?truePred
                :(c)->c.getMpaaRating().equalsIgnoreCase(mpaaCrit);
        directMatch=(direcCrit==null||direcCrit.isEmpty())
                ?truePred
                :(c)->c.getDirector().equalsIgnoreCase(direcCrit);
        releaseMatch=(releaseCrit==null||releaseCrit.isEmpty())
                ?truePred
                :(c)->c.getReleaseDate().equals(releaseCrit);
        
        return dvdMap.values().stream()
                .filter(titleMatch
                        .and(imdbMatch)
                        .and(mpaaMatch)
                        .and(directMatch)
                        .and(releaseMatch))
                        .collect(Collectors.toList());
    }

}
