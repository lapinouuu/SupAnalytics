/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.service;
import com.supinfo.rmt.entity.Acheteur;
import com.supinfo.rmt.exception.UnknownUserException;
import java.util.List;
import javax.ejb.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ejb.Stateless;

/**
 *
 * @author laPinOuu
 */
@Stateless
public class AcheteurService {
    @PersistenceContext
    private EntityManager em;
    /*
    @SuppressWarnings("unchecked")
    public List<Acheteur> listAcheteurs() {
        return em.createQuery("SELECT a FROM Acheteur a WHERE a.name != 'xyz' ")
                .getResultList();
    }
    */
    public Number listAcheteurs() {
        Number nb = (Number) em.createQuery("SELECT COUNT(ac) FROM Acheteur ac")
                .getSingleResult();
        return nb.intValue();
    }
}
