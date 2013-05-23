/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.web.controller;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.List;
import com.supinfo.rmt.service.AcheteurService;
import com.supinfo.rmt.entity.Acheteur;
import java.io.Console;
import java.util.Iterator;

/**
 *
 * @author laPinOuu
 */
@ManagedBean
public class AcheteurController {
    @EJB
    private AcheteurService acheteurService;

    private Acheteur acheteur;

    private DataModel<Acheteur> acheteursModel;
    private Number num;
    
    public Number getAcheteursModel() {
        num = acheteurService.listAcheteurs();
        System.out.println("alo");
        System.out.println(num);
        return null;
    }
       
        
   /* public DataModel<Acheteur> getAcheteursModel() {
        
        if(acheteursModel == null) {
            List<Acheteur> acheteurs = acheteurService.listAcheteurs();
            
            Iterator i = acheteurs.iterator();
            while(i.hasNext()){
                Acheteur achet = (Acheteur)i.next();
                System.out.println("alo");
            }
            System.out.println("aloah");
            acheteursModel = new ListDataModel<Acheteur>(acheteurs);
        }
        return acheteursModel;
    }*/
    
    /**
     * @return the acheteur
     */
    public Acheteur getAcheteur() {
        return acheteur;
    }

    /**
     * @param acheteur the acheteur to set
     */
    public void setAcheteur(Acheteur acheteur) {
        this.acheteur = acheteur;
    }
}
