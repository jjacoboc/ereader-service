/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.dao;

import com.trooper.ereader.model.Section;
import java.util.List;

/**
 *
 * @author root
 */
public interface SectionDao {
    
    List<Section> listByBook(int idBook);
}
