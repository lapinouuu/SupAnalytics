/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.entity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author laPinOuu
 */
@Entity
@Table(name = "ACHETEURS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Acheteur extends User {
    @NotEmpty @Size(min = 2, max = 30)
    private String Gender;
    
    @NotEmpty @Size(min = 2, max = 30)
    private String Marital;
    
    @NotEmpty @Size(min = 2, max = 30)
    private String Income;
    
    @NotEmpty @Size(min = 2, max = 30)
    private String Nb_ventes;
    
    @NotEmpty @Email
    private String Email;

    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the Marital
     */
    public String getMarital() {
        return Marital;
    }

    /**
     * @param Marital the Marital to set
     */
    public void setMarital(String Marital) {
        this.Marital = Marital;
    }

    /**
     * @return the Income
     */
    public String getIncome() {
        return Income;
    }

    /**
     * @param Income the Income to set
     */
    public void setIncome(String Income) {
        this.Income = Income;
    }

    /**
     * @return the Nb_ventes
     */
    public String getNb_ventes() {
        return Nb_ventes;
    }

    /**
     * @param Nb_ventes the Nb_ventes to set
     */
    public void setNb_ventes(String Nb_ventes) {
        this.Nb_ventes = Nb_ventes;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }


}
