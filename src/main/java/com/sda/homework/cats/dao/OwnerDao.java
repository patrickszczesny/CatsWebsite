package com.sda.homework.cats.dao;


import com.sda.homework.cats.config.HibernateUtils;
import com.sda.homework.cats.entity.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OwnerDao implements DaoInterface<Owner> {

    private Session currentSession;
    private Transaction currentTransaction;

    public OwnerDao(){

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
    public Owner save(Owner entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public void update(Owner entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Owner findById(int id) {
        Owner owner = getCurrentSession().get(Owner.class, id);
        return owner;
    }

    @Override
    public void delete(Owner entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteAll() {
        List<Owner> entityList = findAll();
        for (Owner entity : entityList) {
            delete(entity);
        }
    }

    @Override
    public List<Owner> findAll() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Owner> criteriaQuery = criteriaBuilder.createQuery(Owner.class);
        Root<Owner> root = criteriaQuery.from(Owner.class);
        criteriaQuery.select(root);

        return getCurrentSession().createQuery(criteriaQuery).getResultList();
    }
}
