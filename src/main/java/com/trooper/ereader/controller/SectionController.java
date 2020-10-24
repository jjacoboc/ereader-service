/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.controller;

import com.trooper.ereader.model.Section;
import com.trooper.ereader.service.SectionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/sections/{idbook}")
    public ResponseEntity<List<Section>> listByBook(@PathVariable("idbook") int idbook) {
        List<Section> sections = sectionService.listByBook(idbook);
        return ResponseEntity.ok().body(sections);
    }
}
