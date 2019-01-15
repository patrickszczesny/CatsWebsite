package com.sda.homework.cats.dao;


import com.sda.homework.cats.config.HibernateUtils;
import com.sda.homework.cats.entity.Race;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RaceDao implements DaoInterface<Race> {

    private Session currentSession;
    private Transaction currentTransaction;

    public RaceDao(){

    }

    public Session getCurrentSession(){
        return currentSession;
    }

    public synchronized Session openCurrentSession(){
        if(currentSession == null) {
            currentSession = HibernateUtils.getSession();
            }
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public synchronized void closeCurrentSession(){
        currentTransaction.commit();
    }


    @Override
    public Race save(Race entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public void update(Race entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Race findById(int id) {
        Race race = getCurrentSession().get(Race.class, id);
        return race;
    }

    @Override
    public void delete(Race entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteAll() {
        List<Race> entityList = findAll();
        for (Race entity : entityList) {
            delete(entity);
        }
    }

    @Override
    public List<Race> findAll() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Race> criteriaQuery = criteriaBuilder.createQuery(Race.class);
        Root<Race> root = criteriaQuery.from(Race.class);
        criteriaQuery.select(root);

        return getCurrentSession().createQuery(criteriaQuery).getResultList();
    }
}
