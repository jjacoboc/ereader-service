package com.trooper.ereader.dao;

import com.trooper.ereader.model.Magazine;
import java.util.List;

public interface MagazineDao {

   long save(Magazine magazine);
   Magazine get(int id);
   List<Magazine> list();
   void update(int id, Magazine magazine);
   void delete(int id);

}
