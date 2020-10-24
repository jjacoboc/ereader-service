package com.trooper.ereader.dao;

import com.trooper.ereader.model.Book;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImp implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return book.getIdt_book();
    }

    @Override
    public Book get(int id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    public List<Book> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.orderBy(cb.asc(root.get("year")));
        cq.orderBy(cb.asc(root.get("edition")));
        cq.select(root);
        Query<Book> query = session.createQuery(cq);
        return query.getResultList();
    }
    
    @Override
    public List<Book> listByYear(int year) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.where(cb.equal(root.get("year"), year));
        cq.orderBy(cb.asc(root.get("edition")));
        cq.select(root);
        Query<Book> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Integer> listYears() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
        Root<Book> root = cq.from(Book.class);
        cq.groupBy(root.get("year"));
        cq.orderBy(cb.desc(root.get("year")));
        cq.select(root.get("year"));
        Query<Integer> query = session.createQuery(cq);
        return query.getResultList();
    }
    
    @Override
    public List<Integer> listYearsByAudio(int flag) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
        Root<Book> root = cq.from(Book.class);
        cq.where(cb.equal(root.get("has_audio"), flag));
        cq.groupBy(root.get("year"));
        cq.orderBy(cb.desc(root.get("year")));
        cq.select(root.get("year"));
        Query<Integer> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(int id, Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book book2 = session.byId(Book.class).load(id);
        book2.setCode(book.getCode());
        book2.setTitle(book.getTitle());
        book2.setAuthor(book.getAuthor());
        book2.setPublisher(book.getPublisher());
        book2.setEdition(book.getEdition());
        book2.setYear(book.getYear());
        book2.setUrl(book.getUrl());
        book2.setCreated_by(book.getCreated_by());
        book2.setCreated_date(book.getCreated_date());
        book2.setUpdated_by(book.getUpdated_by());
        book2.setUpdated_date(book.getUpdated_date());
        session.flush();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.byId(Book.class).load(id);
        session.delete(book);
    }

}
