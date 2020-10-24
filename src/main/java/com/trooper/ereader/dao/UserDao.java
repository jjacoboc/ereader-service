/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.dao;

import com.trooper.ereader.model.User;
import java.util.List;

public interface UserDao {

    long save(User user);
    User get(int id);
    List<User> list();
    void update(User user);
    void delete(int id);
    User getUserByDocumentTypeAndDocumentNumber(int docType, String docNumber);
    User getUserByEmail(String email);
}
