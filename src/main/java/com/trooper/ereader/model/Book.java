package com.trooper.ereader.model;

import java.io.Serializable;
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
@Table(name = "t_book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idt_book")
    private Integer idt_book;
    
    @Column(name="code")
    private String code;
    
    @Column(name="title")
    private String title;
    
    @Column(name="author")
    private String author;
    
    @Column(name="publisher")
    private String publisher;
    
    @Column(name="edition")
    private Integer edition;
    
    @Column(name="year")
    private Integer year;
    
    @Column(name="url")
    private String url;
    
    @Column(name="has_audio")
    private Integer has_audio;
    
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

    public Integer getIdt_book() {
        return idt_book;
    }

    public void setIdt_book(Integer idt_book) {
        this.idt_book = idt_book;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHas_audio() {
        return has_audio;
    }

    public void setHas_audio(Integer has_audio) {
        this.has_audio = has_audio;
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
