package com.supinfo.rmt.service;

import com.supinfo.rmt.entity.User;
import com.supinfo.rmt.exception.AuthenticationException;
import com.supinfo.rmt.exception.UnknownUserException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 4:05 PM
 */
@Stateless
public class UserService {

    @PersistenceContext
    private EntityManager em;

    //TOUS LES UTILISATEURS
    public List<User> listUsers() {
        return em.createQuery("SELECT a FROM User a")
                .getResultList();
    }
    //TOUS LES HOMMES
    public List<User> listHommes() {
        return em.createQuery("SELECT aa FROM User aa WHERE aa.gender='Homme'")
                .getResultList();
    }
    //TOUTES LES FEMMES
    public List<User> listFemmes() {
        return em.createQuery("SELECT ab FROM User ab WHERE ab.gender='Femme'")
                .getResultList();
    }
    //TOUS LES RICHES (> 3000)
    public List<User> listRiches() {
        return em.createQuery("SELECT ac FROM User ac WHERE ac.income > 3000")
                .getResultList();
    }
    //TOUS LES PAUVRES (< 3000)
    public List<User> listPauvres() {
        return em.createQuery("SELECT ad FROM User ad WHERE ad.income < 3000")
                .getResultList();
    }
    //TOUS CEUX DE TOKYO
    public List<User> listTokyo() {
        return em.createQuery("SELECT ae FROM User ae WHERE ae.ville='Tokyo'")
                .getResultList();
    }
    //TOUS CEUX DE PARIS
    public List<User> listParis() {
        return em.createQuery("SELECT af FROM User af WHERE af.ville='Paris'")
                .getResultList();
    }
    //TOUS CEUX DE MONTREAL
    public List<User> listMontreal() {
        return em.createQuery("SELECT ag FROM User ag WHERE ag.ville='Montreal'")
                .getResultList();
    }
    //TOUS CEUX MARIE
    public List<User> listMarie() {
        return em.createQuery("SELECT ah FROM User ah WHERE ah.marital='Maried'")
                .getResultList();
    }
    //TOUS CEUX PAS MARIE
    public List<User> listPasMarie() {
        return em.createQuery("SELECT ai FROM User ai WHERE ai.marital='Single'")
                .getResultList();
    }
    
    public User authenticate(String username, String password) {
        try {
            User user = findUserByUsername(username);
            if(user.getPassword().equals(password)) {
                return user;
            }
        } catch (UnknownUserException e) {/* Pass to the next instruction */ }
        throw new AuthenticationException(username, password);
    }

    public User findUserByUsername(String username) {
        User user = em.find(User.class, username);
        if(user != null) {
            return user;
        }
        throw new UnknownUserException(username);
    }

    public boolean usernameExists(String username) {
        Number nb = (Number) em.createQuery("SELECT COUNT(u) FROM User u WHERE u.username = :username")
                .setParameter("username", username)
                .getSingleResult();
        return nb.intValue() > 0;
    }

}
