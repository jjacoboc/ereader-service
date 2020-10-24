package com.trooper.ereader.dao;

import com.trooper.ereader.model.Book;
import java.util.List;

public interface BookDao {

   long save(Book book);
   Book get(int id);
   List<Book> list();
   List<Book> listByYear(int year);
   List<Integer> listYears();
   List<Integer> listYearsByAudio(int flag);
   void update(int id, Book book);
   void delete(int id);

}
