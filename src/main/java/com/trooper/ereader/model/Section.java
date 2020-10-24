/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_section")
public class Section implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idt_section")
    private Integer idt_section;
    
    @Column(name="idt_book")
    private Integer idt_book;
    
    @Column(name="name")
    private String name;
    
    @Column(name="order")
    private int order;
    
    @Column(name="created_by")
    private Integer created_by;
    
    @Column(name="created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date;
    
    @Column(name="updated_by")
    private Integer updated_by;
    
    @Column(name="updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_date;

    public Integer getIdt_section() {
        return idt_section;
    }

    public void setIdt_section(Integer idt_section) {
        this.idt_section = idt_section;
    }

    public Integer getIdt_book() {
        return idt_book;
    }

    public void setIdt_book(Integer idt_book) {
        this.idt_book = idt_book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Integer getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Integer getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Integer updated_by) {
        this.updated_by = updated_by;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }
}
