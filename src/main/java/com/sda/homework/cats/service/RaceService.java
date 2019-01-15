package com.sda.homework.cats.service;


import com.sda.homework.cats.dao.RaceDao;
import com.sda.homework.cats.entity.Race;

import java.util.List;

public class RaceService {

    private static RaceDao raceDao;

    public RaceService() {
        raceDao = new RaceDao();
    }

    public void save(Race race){
        raceDao.openCurrentSession();
        raceDao.save(race);
        raceDao.closeCurrentSession();
    }

    public void update(Race race){
        raceDao.openCurrentSession();
        raceDao.update(race);
        raceDao.closeCurrentSession();
    }

    public void delete(int id){
        raceDao.openCurrentSession();
        Race race = raceDao.findById(id);
        raceDao.delete(race);
        raceDao.closeCurrentSession();
    }

    public Race findById(int id){
        raceDao.openCurrentSession();
        Race race = raceDao.findById(id);
        raceDao.closeCurrentSession();
        return race;
    }

    public List<Race> findAll(){
        raceDao.openCurrentSession();
        List<Race> racesList = raceDao.findAll();
        raceDao.closeCurrentSession();
        return racesList;
    }

    public void deleteAll(){
        raceDao.openCurrentSession();
        raceDao.deleteAll();
        raceDao.closeCurrentSession();
    }

}
