package com.trooper.ereader.controller;

import com.trooper.ereader.model.Magazine;
import com.trooper.ereader.service.MagazineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MagazineController {

   @Autowired
   private MagazineService magazineService;

   /*---Add new magazine---*/
   @PostMapping("/magazine")
   public ResponseEntity<?> save(@RequestBody Magazine magazine) {
      long id = magazineService.save(magazine);
      return ResponseEntity.ok().body("New Magazine has been saved with ID:" + id);
   }

   /*---Get a magazine by id---*/
   @GetMapping("/magazine/{id}")
   public ResponseEntity<Magazine> get(@PathVariable("id") int id) {
      Magazine magazine = magazineService.get(id);
      return ResponseEntity.ok().body(magazine);
   }

   /*---get all magazines---*/
   @GetMapping("/magazine")
   public ResponseEntity<List<Magazine>> list() {
      List<Magazine> magazines = magazineService.list();
      return ResponseEntity.ok().body(magazines);
   }

   /*---Update a magazine by id---*/
   @PutMapping("/magazine/{id}")
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Magazine magazine) {
      magazineService.update(id, magazine);
      return ResponseEntity.ok().body("Magazine has been updated successfully.");
   }

   /*---Delete a magazine by id---*/
   @DeleteMapping("/magazine/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") int id) {
      magazineService.delete(id);
      return ResponseEntity.ok().body("Magazine has been deleted successfully.");
   }
}