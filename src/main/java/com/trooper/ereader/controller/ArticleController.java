/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.controller;

import com.trooper.ereader.model.Article;
import com.trooper.ereader.service.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles/{idsection}")
    public ResponseEntity<List<Article>> listBySection(@PathVariable("idsection") int idsection) {
        List<Article> articles = articleService.listBySection(idsection);
        return ResponseEntity.ok().body(articles);
    }
}
