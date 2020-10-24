/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.controller;

import com.trooper.ereader.model.User;
import com.trooper.ereader.service.UserService;
import com.trooper.ereader.util.Constants;
import com.trooper.ereader.util.Util;
import java.math.BigDecimal;
import java.util.List;
import java.util.ResourceBundle;
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
public class UserController {

    @Autowired
    private UserService userService;

    /*---Add new user---*/
    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody User user) {
        long id = userService.save(user);
        return ResponseEntity.ok().body("New User has been saved with ID:" + id);
    }

    /*---Get a user by id---*/
    @GetMapping("/user/{id}")
    public ResponseEntity<User> get(@PathVariable("id") int id) {
        User user = userService.get(id);
        return ResponseEntity.ok().body(user);
    }

    /*---get all users---*/
    @GetMapping("/user")
    public ResponseEntity<List<User>> list() {
        List<User> users = userService.list();
        return ResponseEntity.ok().body(users);
    }

    /*---Update a user by id---*/
    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok().body("User has been updated successfully.");
    }

    /*---Delete a user by id---*/
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        userService.delete(id);
        return ResponseEntity.ok().body("User has been deleted successfully.");
    }

    @PostMapping("/create/suser")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        user.setPassword(Util.generarClave());
        user.setChange_password(BigDecimal.ONE.intValue());
        user.setAvatar("00");
        userService.save(user);
        
        String subject = Constants.welcomeSubject;
        String body = Constants.welcomeBody;
        String[] to = new String[1];
        to[0] = user.getEmail();
        Util.enviarCorreo(to, subject, body.replace("{1}", user.getNames()).replace("{2}", user.getDocument_number()).replace("{3}", user.getPassword()));
        
        return ResponseEntity.ok().body("User crated successfully.");
    }

    /*---Get a user by email---*/
    @GetMapping("/login/{docType}/{docNumber}")
    public ResponseEntity<User> getUserByDocumentTypeAndDocumentNumber(@PathVariable("docType") int docType, @PathVariable("docNumber") String docNumber) {
        User user = userService.getUserByDocumentTypeAndDocumentNumber(docType, docNumber);
        if(user != null)
            return ResponseEntity.ok().body(user);
        else
            return ResponseEntity.notFound().build();
    }

    /*---Get a user by email---*/
    @GetMapping("/user/email/{param}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("param") String param) {
        User user = userService.getUserByEmail(param.replace(":", "."));
        if(user != null)
            return ResponseEntity.ok().body(user);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/reset/password/")
    public ResponseEntity<?> resetPassword(@RequestBody User user) {
        user.setPassword(Util.generarClave());
        userService.update(user);

        String subject = Constants.rpSubject;
        String body = Constants.rpBody;
        String[] to = new String[1];
        to[0] = user.getEmail();
        Util.enviarCorreo(to, subject, body.replace("{1}", user.getNames()).replace("{2}", user.getPassword()));

        return ResponseEntity.ok().body("Contraseña restablecida");
    }
}
