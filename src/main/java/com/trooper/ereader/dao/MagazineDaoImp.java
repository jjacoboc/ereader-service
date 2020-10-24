package com.trooper.ereader.dao;

import com.trooper.ereader.model.Magazine;
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
public class MagazineDaoImp implements MagazineDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Magazine magazine) {
      sessionFactory.getCurrentSession().save(magazine);
      return magazine.getIdt_magazine();
   }

   @Override
   public Magazine get(int id) {
      return sessionFactory.getCurrentSession().get(Magazine.class, id);
   }

   @Override
   public List<Magazine> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Magazine> cq = cb.createQuery(Magazine.class);
      Root<Magazine> root = cq.from(Magazine.class);
      cq.select(root);
      Query<Magazine> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(int id, Magazine magazine) {
      Session session = sessionFactory.getCurrentSession();
      Magazine magazine2 = session.byId(Magazine.class).load(id);
      magazine2.setCode(magazine.getCode());
      magazine2.setTitle(magazine.getTitle());
      magazine2.setAuthor(magazine.getAuthor());
      magazine2.setYear(magazine.getYear());
      magazine2.setNumber(magazine.getNumber());
      magazine2.setUrl(magazine.getUrl());
      magazine2.setCreated_by(magazine.getCreated_by());
      magazine2.setCreated_date(magazine.getCreated_date());
      magazine2.setUpdated_by(magazine.getUpdated_by());
      magazine2.setUpdated_date(magazine.getUpdated_date());
      session.flush();
   }

   @Override
   public void delete(int id) {
      Session session = sessionFactory.getCurrentSession();
      Magazine magazine = session.byId(Magazine.class).load(id);
      session.delete(magazine);
   }

}
