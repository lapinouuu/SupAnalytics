package com.supinfo.rmt.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/30/12
 * Time: 5:51 PM
 */
@Entity
public class WorkTime {

    @Id @GeneratedValue
    private Long id;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date begin;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date end;

    @NotNull
    @ManyToOne @JoinColumn
    private Client client;

    @NotNull
    @ManyToOne @JoinColumn
    private Employee employee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
