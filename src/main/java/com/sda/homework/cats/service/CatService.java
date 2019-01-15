package com.sda.homework.cats.service;

import com.sda.homework.cats.dao.CatDao;
import com.sda.homework.cats.entity.Cat;

import java.util.List;

public class CatService {

    private static CatDao catDao;

    public CatService() {
        catDao = new CatDao();
    }

    public void save(Cat cat){
        catDao.openCurrentSession();
        catDao.save(cat);
        catDao.closeCurrentSession();
    }

    public void update(Cat cat){
        catDao.openCurrentSession();
        catDao.update(cat);
        catDao.closeCurrentSession();
    }

    public void delete(int id){
        catDao.openCurrentSession();
        Cat cat = catDao.findById(id);
        catDao.delete(cat);
        catDao.closeCurrentSession();
    }

    public Cat findById(int id){
        catDao.openCurrentSession();
        Cat cat = catDao.findById(id);
        catDao.closeCurrentSession();
        return cat;
    }

    public List<Cat> findAll(){
        catDao.openCurrentSession();
        List<Cat> catsList = catDao.findAll();
        catDao.closeCurrentSession();
        return catsList;
    }

    public void deleteAll(){
        catDao.openCurrentSession();
        catDao.deleteAll();
        catDao.closeCurrentSession();
    }

}
