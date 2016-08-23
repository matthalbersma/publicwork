/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teamdadcapstoneproject.dao;

import com.mycompany.teamdadcapstoneproject.model.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrew Cross alias Michael Saltire
 */
public class DaoImpl implements DaoInterface {

    private Post post = new Post();

    private ArrayList<Post> postList = new ArrayList<>();

    private static final String SQL_SELECT_POST
            = "select * from Blog_posts WHERE Blog_postsID=?";
    private static final String SQL_SELECT_ALL_POSTS
            = "select * from Blog_posts WHERE (GoLiveDate<=NOW() OR GoLiveDate IS NULL) AND (ExpireDate>=NOW() OR ExpireDate IS NULL) AND Status = 'Post' ORDER BY Blog_postsID DESC";
    private static final String SQL_INSERT_POST
            = "insert into Blog_posts (Body, URL, GoLiveDate, ExpireDate, Status, Title) value (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_POST
            = "delete from Blog_posts WHERE Blog_postsID=?";
    private static final String SQL_UPDATE_POST
            = "update Blog_posts set Body= ?, GoLiveDate=?, ExpireDate=?, Status=?, URL=?, Title=? WHERE Blog_postsID=?";
    private static final String SQL_SELECT_PENDING
            = "select * from Blog_posts WHERE Status='Pending'";
    private static final String SQL_SELECT_STATIC
            = "select * from Blog_posts WHERE Status='Static'";
    private static final String SQL_SELECT_EXPIRED
            ="select * from Blog_posts WHERE ExpireDate<NOW()";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post addPost(Post post) {
        jdbcTemplate.update(SQL_INSERT_POST,
                post.getContent(),
                post.getAllTags(),
                post.getGoLive(),
                post.getExpire(),
                post.getStatus(),
                post.getTitle()
        //                post.getTitle(),
        //                post.getUrl(),
        //                post.getCategories()
        );

        post.setPostId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class));
        return post;

    }

    @Override
    public List<Post> returnActive() {
        return jdbcTemplate.query(SQL_SELECT_ALL_POSTS, new PostMapper());
    }

    @Override
    public void deletePost(int postID) {
        jdbcTemplate.update(SQL_DELETE_POST, postID);
    }

    @Override
    public void updatePost(Post post) {
        jdbcTemplate.update(SQL_UPDATE_POST,
                post.getContent(),
                post.getGoLive(),
                post.getExpire(),
                post.getStatus(),
                post.getAllTags(),
                post.getTitle(),
                post.getPostId());
        

    }

    @Override
    public List<Post> returnStatic() {
        return jdbcTemplate.query(SQL_SELECT_STATIC, new PostMapper());
    }

    @Override
    public List<Post> search(String term) {
        List<Post> all = returnActive();
        List<Post> results = new ArrayList<>();
        for (Post c : all) {
            if (c.getContent().contains(term)) {
                results.add(c);
            }
        }
        return results;
    }

    @Override
    public Post returnPostById(int postID) {

        return jdbcTemplate.queryForObject(SQL_SELECT_POST,
                new PostMapper(), postID);
    }

    @Override
    public List<Post> returnPending() {
        return jdbcTemplate.query(SQL_SELECT_PENDING, new PostMapper());
    }

    @Override
    public List<Post> returnExpired() {
         return jdbcTemplate.query(SQL_SELECT_EXPIRED, new PostMapper());
    }

    private static final class PostMapper implements RowMapper<Post> {

        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            // post.setCategories(rs.getString("categories"));
            post.setContent(rs.getString("body"));
            post.setExpire(rs.getString("ExpireDate"));//TODO fix me!!!
            post.setPostId(rs.getInt("Blog_postsID"));
            post.setTitle(rs.getString("Title"));
            post.setGoLive(rs.getString("GoLiveDate"));//TODO fix me!!!
            post.setStatus(rs.getString("Status"));//TODO getEnum???
            post.setAllTags(rs.getString("URL"));
            return post;
        }
    }
}
