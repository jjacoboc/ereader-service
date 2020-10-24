/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.service;

import com.trooper.ereader.dao.ArticleDao;
import com.trooper.ereader.model.Article;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ArticleServiceImp implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    
    @Override
    public List<Article> listBySection(int idSection) {
        return articleDao.listBySection(idSection);
    }
    
}
