package com.sda.homework.cats.service;


import com.sda.homework.cats.dao.OwnerDao;
import com.sda.homework.cats.entity.Owner;

import java.util.List;

public class OwnerService {

    private static OwnerDao ownerDao;

    public OwnerService() {
        ownerDao = new OwnerDao();
    }

    public void save(Owner owner){
        ownerDao.openCurrentSession();
        ownerDao.save(owner);
        ownerDao.closeCurrentSession();
    }

    public void update(Owner owner){
        ownerDao.openCurrentSession();
        ownerDao.update(owner);
        ownerDao.closeCurrentSession();
    }

    public void delete(int id){
        ownerDao.openCurrentSession();
        Owner owner = ownerDao.findById(id);
        ownerDao.delete(owner);
        ownerDao.closeCurrentSession();
    }

    public Owner findById(int id){
        ownerDao.openCurrentSession();
        Owner owner = ownerDao.findById(id);
        ownerDao.closeCurrentSession();
        return owner;
    }

    public List<Owner> findAll(){
        ownerDao.openCurrentSession();
        List<Owner> ownersList = ownerDao.findAll();
        ownerDao.closeCurrentSession();
        return ownersList;
    }

    public void deleteAll(){
        ownerDao.openCurrentSession();
        ownerDao.deleteAll();
        ownerDao.closeCurrentSession();
    }

}
