package com.mycompany.teamdadcapstoneproject.controller;

import com.mycompany.teamdadcapstoneproject.dao.DaoInterface;
import com.mycompany.teamdadcapstoneproject.model.Hashtags;
import com.mycompany.teamdadcapstoneproject.model.Post;
import com.mycompany.teamdadcapstoneproject.model.Search;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    DaoInterface dao;
    Hashtags ht = new Hashtags();

    @Inject
    public HomeController(DaoInterface dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

    @RequestMapping(value = {"aboutme"}, method = RequestMethod.GET)
    public String displayAboutMe() {
        return "aboutme";
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> returnAll() {
        List<Post> toReturn = dao.returnActive();

        return toReturn;
    }

    @RequestMapping(value = {"post"}, method = RequestMethod.GET)
    public String displayPostPage() {
        return "adminPost";
    }

    @RequestMapping(value = {"pending"}, method = RequestMethod.GET)
    public String displayPendingPage() {
        return "adminPendingPosts";
    }

    @RequestMapping(value = "/addcontent", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Post addPost(@Valid @RequestBody Post post) {
        String check = post.getContent();
        post.setAllTags(ht.hashTagMaker(check));
        dao.addPost(post);
        return post;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") int id) {

        dao.deletePost(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<Post> search(@Valid @RequestBody Search term) {

        return dao.search(term.getTerm());
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Post displayEditModal(@PathVariable("id") int id) {

        return dao.returnPostById(id);
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveEdit(@PathVariable("id") int id, @Valid @RequestBody Post post) {
        String check = post.getContent();
        post.setAllTags(ht.hashTagMaker(check));
        post.setPostId(id);
        dao.updatePost(post);
    }

    @RequestMapping(value="/pendNum", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public int numPendingPosts(){
        return dao.returnPending().size();
    }
 
    @RequestMapping(value="/pendingPosts", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<Post> returnPending() {
        return dao.returnPending();
    }
    
    @RequestMapping(value="/staticPost", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<Post> loadStatic(){
        return dao.returnStatic();
    }
    @RequestMapping(value="/expiredNum", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public int numExpiredPosts(){
        return dao.returnExpired().size();
    }
    @RequestMapping(value="/expiredPosts", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<Post> returnExpired() {
        return dao.returnExpired();
    }
}
