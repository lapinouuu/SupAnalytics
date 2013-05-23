package com.supinfo.rmt.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {

    @Id
    @NotEmpty @Size(min = 4, max = 20)
    private String username;

    @NotEmpty @Size(min = 4, max = 20)
    private String password;

    @NotEmpty @Size(min = 2, max = 30)
    private String firstName;

    @NotEmpty @Size(min = 2, max = 30)
    private String lastName;
    
    @NotEmpty @Size(min = 2, max = 30)
    private String nb_ventes;
    
    @NotEmpty @Size(min = 2, max = 30)
    private String gender;
    
    @NotEmpty @Size(min = 2, max = 30)
    private String marital;
    
    @NotEmpty @Size(min = 2, max = 30)
    private String income;

    @NotEmpty @Email
    private String email;
    
    @NotEmpty @Size(min = 2, max = 30)
    private String ville;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;


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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof User)) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    /**
     * @return the nb_ventes
     */
    public String getNb_ventes() {
        return nb_ventes;
    }

    /**
     * @param nb_ventes the nb_ventes to set
     */
    public void setNb_ventes(String nb_ventes) {
        this.nb_ventes = nb_ventes;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the marital
     */
    public String getMarital() {
        return marital;
    }

    /**
     * @param marital the marital to set
     */
    public void setMarital(String marital) {
        this.marital = marital;
    }

    /**
     * @return the income
     */
    public String getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(String income) {
        this.income = income;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

}
