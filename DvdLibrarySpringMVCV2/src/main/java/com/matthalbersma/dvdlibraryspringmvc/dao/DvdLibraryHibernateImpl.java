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
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author walter
 */
@Repository
@Transactional
public class DvdLibraryHibernateImpl implements DvdLibrary {

    private SessionFactory sessionFactory;

    @Inject
    public DvdLibraryHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addDvd(DVD dvd) {
        currentSession().save(dvd);
    }

    @Override
    public void removeDvd(int id) {
        DVD toDelete = getByID(id);
        currentSession().delete(toDelete);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void editDvd(DVD dvd) {
        currentSession().update(dvd);
    }

    @Override
    public ArrayList<DVD> getAll() {
        return (ArrayList<DVD>) currentSession().createCriteria(DVD.class).list();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DVD getByID(int id) {
        return (DVD) currentSession().get(DVD.class, id);
    }

    @Override
    public List<DVD> searchList(Map<SearchType, String> crit) {
        String titleCrit = crit.get(SearchType.TITLE);
        String imdbCrit = crit.get(SearchType.IMDBID);
        String mpaaCrit = crit.get(SearchType.MPAA);
        String direcCrit = crit.get(SearchType.DIRECTOR);
        String releaseCrit = crit.get(SearchType.RELEASEDATE);

        Criteria cr = currentSession().createCriteria(DVD.class);
        if (titleCrit!=null && !titleCrit.isEmpty()) {
            cr.add(Restrictions.like("title", "%" + titleCrit + "%"));
        }
        if (imdbCrit!=null&&!imdbCrit.isEmpty()) {
            cr.add(Restrictions.like("imdbID", imdbCrit, MatchMode.EXACT));
        }
        if (releaseCrit!=null&&!releaseCrit.isEmpty()) {
            cr.add(Restrictions.like("releaseDate", "%" + releaseCrit + "%"));
        }
        if (mpaaCrit!=null&&!mpaaCrit.isEmpty()) {
            cr.add(Restrictions.like("mpaaRating", mpaaCrit, MatchMode.EXACT));
        }
        if (direcCrit!=null&&!direcCrit.isEmpty()) {
            cr.add(Restrictions.like("director", "%" + direcCrit + "%"));
        }

        return cr.list();
    }

}
