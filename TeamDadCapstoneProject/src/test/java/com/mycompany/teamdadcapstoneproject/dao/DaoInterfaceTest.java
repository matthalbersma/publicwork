/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teamdadcapstoneproject.dao;

import com.mycompany.teamdadcapstoneproject.model.Post;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Andrew Cross alias Michael Saltire
 */
public class DaoInterfaceTest {

    private DaoInterface dao;

    public DaoInterfaceTest() {
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
        dao = ctx.getBean("DaoInterface", DaoInterface.class);

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from Blog_posts");

    }

    @After
    public void tearDown() {
    }

    @Test

    public void returnActive() {
        //TESTS RETURN ACTIVE AND ADD

        Post p1 = new Post();
        p1.setPostId(0);
        p1.setTitle("title");
        p1.setStatus("Post");
        p1.setContent("Content so nice, it like whoa");

        dao.addPost(p1);

        Post p2 = new Post();

        p2.setTitle("title2");
        p2.setStatus("Post");

        p2.setContent("Content so nice, it like whoa X2");

        dao.addPost(p2);

        List<Post> pList = dao.returnActive();
        assertEquals(pList.size(), 2);
        dao.deletePost(pList.get(1).getPostId());
        pList = dao.returnActive();
        assertEquals(pList.size(), 1);

    }

    @Test

    public void testSearch() {
        //TESTS ADD POST AND SEARCH
        Post test1 = new Post();
        test1.setContent("Its a thing to search this #shiz #hip #hat");
        test1.setPostId(0);
        test1.setStatus("Post");
        dao.addPost(test1);
        Post test2 = new Post();
        test2.setStatus("Post");
        test2.setContent("Got those rockets #shiz #ham #morgan");
        dao.addPost(test2);
        List<Post> testResults = dao.search("#shiz");
        assertEquals(testResults.size(), 2);
        testResults = dao.search("things");
        assertTrue(testResults.isEmpty());

    }

    @Test
    public void testEdit() {
        //TESTS ADD POST, RETURN ALL, UPDATE POST
        Post test1 = new Post();
        test1.setStatus("Post");
        test1.setContent("Its a thing to search this #shiz #hip #hat");
        test1.setPostId(0);
        dao.addPost(test1);
        test1.setContent("Morgan Fairchild");
        dao.updatePost(test1);
        List<Post> results = dao.returnActive();
        assertEquals(results.get(0).getContent(), "Morgan Fairchild");

    }

    @Test
    public void testReturnDeleteById() {
        Post test = new Post();

        test.setContent("crazy horse ate neil young");
        test.setStatus("Post");
        dao.addPost(test);
        Post result = dao.returnActive().get(0);
        Post testResult = dao.returnPostById(result.getPostId());
        assertEquals(result, testResult);

        dao.deletePost(result.getPostId());
        List<Post> returnResults = dao.returnActive();

        assertEquals(0, returnResults.size());
    }

    @Test
    public void testReturnStaticExpired() {
        Post staticPost1 = new Post();
        Post staticPost2 = new Post();

        staticPost1.setStatus("Post");
        staticPost2.setStatus("Static");

        staticPost1.setExpire("1959-08-12 12:00:00");
        staticPost2.setExpire("3000-08-12 12:00:00");

        staticPost1.setContent("short");
        staticPost2.setContent("shorter");

        dao.addPost(staticPost2);
        dao.addPost(staticPost1);

        List<Post> results = dao.returnStatic();

        assertEquals(results.size(), 1);
        assertEquals(results.get(0).getContent(), "shorter");

        results = dao.returnExpired();

        assertEquals(results.size(), 1);
        assertEquals(results.get(0).getContent(), "short");
    }

    @Test
    public void testReturnPending() {

        Post staticPost1 = new Post();
        Post staticPost2 = new Post();

        staticPost1.setStatus("Post");
        staticPost2.setStatus("Pending");

        staticPost1.setContent("short");
        staticPost2.setContent("shorter");

        dao.addPost(staticPost2);
        dao.addPost(staticPost1);

        List<Post> results = dao.returnPending();

        assertEquals(results.size(), 1);
        assertEquals(results.get(0).getContent(), "shorter");

    }

}
