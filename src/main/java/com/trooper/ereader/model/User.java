/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_user")
public class User implements Serializable, Comparable<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idt_user")
    private Integer idt_user;
    
    @Column(name="names")
    private String names;
    
    @Column(name="last_names")
    private String last_names;
    
    @Column(name="document_type")
    private Integer document_type;
    
    @Column(name="document_number")
    private String document_number;
    
    @Column(name="email")
    private String email;
    
    @Column(name="cip")
    private String cip;
    
    @Column(name="grade")
    private String grade;
    
    @Column(name="speciality")
    private String speciality;
    
    @Column(name="avatar")
    private String avatar;
    
    @Column(name="change_password")
    private Integer change_password;
    
    @Column(name="password")
    private String password;
    
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

    public Integer getIdt_user() {
        return idt_user;
    }

    public void setIdt_user(Integer idt_user) {
        this.idt_user = idt_user;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLast_names() {
        return last_names;
    }

    public void setLast_names(String last_names) {
        this.last_names = last_names;
    }

    public Integer getDocument_type() {
        return document_type;
    }

    public void setDocument_type(Integer document_type) {
        this.document_type = document_type;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getChange_password() {
        return change_password;
    }

    public void setChange_password(Integer change_password) {
        this.change_password = change_password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public int compareTo(User o) {
        return this.idt_user - o.idt_user;
    }
    
    public static Comparator<User> NamesComparator = (User u1, User u2) -> u1.getNames().compareTo(u2.getNames());
    public static Comparator<User> LastNamesComparator = (User u1, User u2) -> u1.getLast_names().compareTo(u2.getLast_names());
    public static Comparator<User> DocumentNumberComparator = (User u1, User u2) -> u1.getDocument_number().compareTo(u2.getDocument_number());
    public static Comparator<User> EmailComparator = (User u1, User u2) -> u1.getEmail().compareTo(u2.getEmail());
}
