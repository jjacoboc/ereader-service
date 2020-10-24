/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.dao;

import com.trooper.ereader.model.Section;
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
public class SectionDaoImp implements SectionDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Section> listByBook(int idBook) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Section> cq = cb.createQuery(Section.class);
        Root<Section> root = cq.from(Section.class);
        cq.where(cb.equal(root.get("idt_book"), idBook));
        cq.orderBy(cb.asc(root.get("order")));
        cq.select(root);
        Query<Section> query = session.createQuery(cq);
        return query.getResultList();
    }
    
}
