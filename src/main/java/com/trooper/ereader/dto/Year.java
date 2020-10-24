/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.dto;

import com.trooper.ereader.model.Book;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author root
 */
public class Year implements Serializable {
    
    private Integer year;
    private List<Book> books;
    
    public Year() {}
    
    public Year(Integer year, List<Book> books) {
        this.year = year;
        this.books = books;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
