/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma.dvdlibraryspringmvc;

import com.matthalbersma.dvdlibraryspringmvc.dao.DvdLibrary;
import com.matthalbersma.dvdlibraryspringmvc.dao.SearchType;
import static com.matthalbersma.dvdlibraryspringmvc.dao.SearchType.DIRECTOR;
import static com.matthalbersma.dvdlibraryspringmvc.dao.SearchType.TITLE;
import com.matthalbersma.dvdlibraryspringmvc.dto.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author walter
 */
public class DvdDaoTest {

    private DvdLibrary dao;

    public DvdDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("dvdLibraryDao", DvdLibrary.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addDeleteDVD() {
        DVD d = new DVD();
        d.setImdbID("112");
        d.setDirector("herring");
        d.setMpaaRating("G");
        d.setTitle("batman");
        d.setUserRating("terrible");
        d.setReleaseDate("1996");
        d.setCoverURL("home.jpg");
        //add dvd
        dao.addDvd(d);
        DVD fromDao = dao.getByID(d.getId());
        assertEquals(d, fromDao);
        //remove dvd
        dao.removeDvd(d.getId());
        assertNull(dao.getByID(d.getId()));
    }

    @Test
    public void testEditDVD() {
        DVD d = new DVD();
        d.setImdbID("112");
        d.setDirector("herring");
        d.setMpaaRating("G");
        d.setTitle("batman");
        d.setUserRating("terrible");
        d.setReleaseDate("1996");
        d.setCoverURL("home.jpg");

        dao.addDvd(d);

        d.setDirector("morgan");
        d.setReleaseDate("1998");
        dao.editDvd(d);
        assertEquals(dao.getByID(d.getId()).getDirector(), "morgan");
        assertEquals(dao.getByID(d.getId()).getReleaseDate(), "1998");
    }

    @Test
    public void testSearch() {
        DVD d = new DVD();
        d.setImdbID("112");
        d.setDirector("herring");
        d.setMpaaRating("G");
        d.setTitle("batman");
        d.setUserRating("terrible");
        d.setReleaseDate("1996");
        d.setCoverURL("home.jpg");

        dao.addDvd(d);
        
        Map<SearchType, String> a=new HashMap<>();
        a.put(TITLE, "batman");
        List<DVD> b=dao.searchList(a);
        assertTrue(b.size()==1);
        
        a.put(DIRECTOR, "hering");
        b=dao.searchList(a);
        assertTrue(b.isEmpty());
        
    }
    @Test
    public void testreturnAll(){
        DVD d = new DVD();
        d.setImdbID("112");
        d.setDirector("herring");
        d.setMpaaRating("G");
        d.setTitle("batman");
        d.setUserRating("terrible");
        d.setReleaseDate("1996");
        d.setCoverURL("home.jpg");
        
        dao.addDvd(d);
        DVD e = new DVD();
        e.setImdbID("112");
        e.setDirector("herring");
        e.setMpaaRating("G");
        e.setTitle("batman");
        e.setUserRating("terrible");
        e.setReleaseDate("1996");
        e.setCoverURL("home.jpg");
        dao.addDvd(e);
        
        List<DVD> test= dao.getAll();
        assertTrue(test.size()==2);
        assertTrue(test.contains(e));
    }
}
