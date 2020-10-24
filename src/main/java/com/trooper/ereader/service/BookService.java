package com.trooper.ereader.service;

import com.trooper.ereader.dto.Year;
import com.trooper.ereader.model.Book;
import java.util.List;

public interface BookService {

   long save(Book book);
   Book get(int id);
   List<Book> list();
   List<Book> listByYear(int year);
   List<Year> listYears();
   List<Year> listYearsByAudio(int flag);
   void update(int id, Book book);
   void delete(int id);
}
