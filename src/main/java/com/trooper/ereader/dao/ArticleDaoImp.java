/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.dao;

import com.trooper.ereader.model.Article;
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
public class ArticleDaoImp implements ArticleDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Article> listBySection(int idSection) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Article> cq = cb.createQuery(Article.class);
        Root<Article> root = cq.from(Article.class);
        cq.where(cb.equal(root.get("idt_section"), idSection));
        cq.orderBy(cb.asc(root.get("order")));
        cq.select(root);
        Query<Article> query = session.createQuery(cq);
        return query.getResultList();
    }
    
}
