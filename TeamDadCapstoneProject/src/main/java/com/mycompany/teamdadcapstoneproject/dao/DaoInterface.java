/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teamdadcapstoneproject.dao;

import com.mycompany.teamdadcapstoneproject.model.Post;
import java.util.List;

/**
 *
 * @author Andrew Cross alias Michael Saltire
 */
public interface DaoInterface {
    
    public abstract Post addPost(Post post);

    public abstract List<Post> returnActive();
    
    public abstract Post returnPostById(int postID);

    public abstract void deletePost(int postID);

    public abstract void updatePost(Post post);

    public abstract List<Post> returnStatic();

    public abstract List<Post> search(String term);
    
    public abstract List<Post> returnPending();
    
    public abstract List<Post> returnExpired();
    
}
