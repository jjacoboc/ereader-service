package com.trooper.ereader.service;

import com.trooper.ereader.dao.BookDao;
import com.trooper.ereader.dto.Year;
import com.trooper.ereader.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BookServiceImp implements BookService {

   @Autowired
   private BookDao bookDao;

   @Transactional
   @Override
   public long save(Book book) {
      return bookDao.save(book);
   }

   @Override
   public Book get(int id) {
      return bookDao.get(id);
   }

   @Override
   public List<Book> list() {
      return bookDao.list();
   }
   
   @Override
   public List<Book> listByYear(int year) {
      return bookDao.listByYear(year);
   }
   
   @Override
   public List<Year> listYears() {
       List<Year> result = new ArrayList<>();
       List<Integer> years = bookDao.listYears();
       years.forEach((year) -> {
           List<Book> books = bookDao.listByYear(year);
           result.add(new Year(year, books));
       });
      return result;
   }
   
   @Override
   public List<Year> listYearsByAudio(int flag) {
       List<Year> result = new ArrayList<>();
       List<Integer> years = bookDao.listYearsByAudio(flag);
       years.forEach((year) -> {
           List<Book> books = bookDao.listByYear(year);
           result.add(new Year(year, books));
       });
      return result;
   }

   @Transactional
   @Override
   public void update(int id, Book book) {
      bookDao.update(id, book);
   }

   @Transactional
   @Override
   public void delete(int id) {
      bookDao.delete(id);
   }

}
