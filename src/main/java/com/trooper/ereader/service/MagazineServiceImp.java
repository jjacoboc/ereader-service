package com.trooper.ereader.service;

import com.trooper.ereader.dao.MagazineDao;
import com.trooper.ereader.model.Magazine;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MagazineServiceImp implements MagazineService {

   @Autowired
   private MagazineDao magazineDao;

   @Transactional
   @Override
   public long save(Magazine magazine) {
      return magazineDao.save(magazine);
   }

   @Override
   public Magazine get(int id) {
      return magazineDao.get(id);
   }

   @Override
   public List<Magazine> list() {
      return magazineDao.list();
   }

   @Transactional
   @Override
   public void update(int id, Magazine magazine) {
      magazineDao.update(id, magazine);
   }

   @Transactional
   @Override
   public void delete(int id) {
      magazineDao.delete(id);
   }

}
