/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthalbersma.dvdlibraryspringmvc.dto;
//import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author apprentice
 */
@Entity
@Table(name="Dvd")
public class DVD {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="imdbID")
    private String imdbID;
    @Column(name="title")
    private String title;
    @Column(name="releaseDate")
    private String releaseDate;
    @Column(name="mpaaRating")
    private String mpaaRating;
    @Column(name="director")
    private String director;
    @Column(name="userRating")
    private String userRating;
    @Column(name="coverURL")
    private String coverURL;

    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the mpaaRating
     */
    public String getMpaaRating() {
        return mpaaRating;
    }

    /**
     * @param mpaaRating the mpaaRating to set
     */
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the userRating
     */
    public String getUserRating() {
        return userRating;
    }

    /**
     * @param userRating the userRating to set
     */
    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
    public String toString(){
        return " "+ title+", "+director+", "+releaseDate+", "+mpaaRating+", "+userRating;
        
    }
     public boolean equals(DVD s) {
        return title.equals(s.title)
                && releaseDate.equals(s.releaseDate)
                && mpaaRating.equals(s.mpaaRating)
                && userRating.equals(s.userRating);
     }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the coverURL
     */
    public String getCoverURL() {
        return coverURL;
    }

    /**
     * @param coverURL the coverURL to set
     */
    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    /**
     * @return the imdbID
     */
    public String getImdbID() {
        return imdbID;
    }

    /**
     * @param imdbID the imdbID to set
     */
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
}
