package com.sda.homework.cats.dao;


import com.sda.homework.cats.config.HibernateUtils;
import com.sda.homework.cats.entity.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AccountDao implements DaoInterface<Account> {

    private Session currentSession;
    private Transaction currentTransaction;

    public AccountDao(){

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
    public Account save(Account entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public void update(Account entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Account findById(int id) {
        Account account = getCurrentSession().get(Account.class, id);
        return account;
    }

    @Override
    public void delete(Account entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteAll() {
        List<Account> entityList = findAll();
        for (Account entity : entityList) {
            delete(entity);
        }
    }

    @Override
    public List<Account> findAll() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
        Root<Account> root = criteriaQuery.from(Account.class);
        criteriaQuery.select(root);

        return getCurrentSession().createQuery(criteriaQuery).getResultList();
    }
}
