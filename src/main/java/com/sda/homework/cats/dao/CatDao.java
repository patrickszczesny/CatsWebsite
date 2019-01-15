package com.sda.homework.cats.dao;


import com.sda.homework.cats.config.HibernateUtils;
import com.sda.homework.cats.entity.Cat;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CatDao implements DaoInterface<Cat> {

    private Session currentSession;
    private Transaction currentTransaction;

    public CatDao(){

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
    public Cat save(Cat entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public void update(Cat entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Cat findById(int id) {
        Cat cat = getCurrentSession().get(Cat.class, id);
        return cat;
    }

    @Override
    public void delete(Cat entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteAll() {
        List<Cat> entityList = findAll();
        for (Cat entity : entityList) {
            delete(entity);
        }
    }

    @Override
    public List<Cat> findAll() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Cat> criteriaQuery = criteriaBuilder.createQuery(Cat.class);
        Root<Cat> root = criteriaQuery.from(Cat.class);
        criteriaQuery.select(root);

        return getCurrentSession().createQuery(criteriaQuery).getResultList();
    }
}
