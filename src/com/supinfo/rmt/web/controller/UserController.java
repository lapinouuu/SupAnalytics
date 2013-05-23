package com.supinfo.rmt.web.controller;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;
import com.supinfo.rmt.entity.User;
import com.supinfo.rmt.exception.AuthenticationException;
import com.supinfo.rmt.service.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 4:01 PM
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UserService userService;

    private String username;
    private String password;
    private DataModel<User> usersModel;
    private DataModel<User> hommesModel;
    private DataModel<User> femmesModel;
    private DataModel<User> richesModel;
    private DataModel<User> pauvresModel;
    private DataModel<User> parisModel;
    private DataModel<User> montrealModel;
    private DataModel<User> tokyoModel;
    private DataModel<User> marieModel;
    private DataModel<User> pasmarieModel;
    private User user;

    public DataModel<User> getUsersModel() {
        
        if(usersModel == null) {
            List<User> users = userService.listUsers();
            usersModel = new ListDataModel<User>(users);
        }
        return usersModel;
    }
    public DataModel<User> getMariesModel() {
        
        if(marieModel == null) {
            List<User> users = userService.listMarie();
            marieModel = new ListDataModel<User>(users);
        }
        return marieModel;
    }
    public DataModel<User> getPasMariesModel() {
        
        if(pasmarieModel == null) {
            List<User> users = userService.listPasMarie();
            pasmarieModel = new ListDataModel<User>(users);
        }
        return pasmarieModel;
    }
    public DataModel<User> getHommesModel() {
        
        if(hommesModel == null) {
            List<User> users = userService.listHommes();
            hommesModel = new ListDataModel<User>(users);
        }
        return hommesModel;
    }
    public DataModel<User> getFemmesModel() {
        
        if(femmesModel == null) {
            List<User> users = userService.listFemmes();
            femmesModel = new ListDataModel<User>(users);
        }
        return femmesModel;
    }
    public DataModel<User> getRichesModel() {
        
        if(richesModel == null) {
            List<User> users = userService.listRiches();
            richesModel = new ListDataModel<User>(users);
        }
        return richesModel;
    }
    public DataModel<User> getPauvresModel() {
        
        if(pauvresModel == null) {
            List<User> users = userService.listPauvres();
            pauvresModel = new ListDataModel<User>(users);
        }
        return pauvresModel;
    }
    public DataModel<User> getParisModel() {
        
        if(parisModel == null) {
            List<User> users = userService.listParis();
            parisModel = new ListDataModel<User>(users);
        }
        return parisModel;
    }
    public DataModel<User> getMontrealModel() {
        
        if(montrealModel == null) {
            List<User> users = userService.listMontreal();
            montrealModel = new ListDataModel<User>(users);
        }
        return montrealModel;
    }
    public DataModel<User> getTokyoModel() {
        
        if(tokyoModel == null) {
            List<User> users = userService.listTokyo();
            tokyoModel = new ListDataModel<User>(users);
        }
        return tokyoModel;
    }
    
    public String login() {
        try {
            user = userService.authenticate(username, password);
            if(user instanceof Manager) {
                return "home?faces-redirect=true";
            } else if(user instanceof Employee) {
                return "home?faces-redirect=true";
            }
        } catch (AuthenticationException e) {
            FacesUtil.addErrorMessage("Bad credentials, please try again.", null);
        }
        return null;
    }

    public boolean isAuthenticated() {
        return getUser() != null;
    }

    public String logout() {
        user = null;
        return "login?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
