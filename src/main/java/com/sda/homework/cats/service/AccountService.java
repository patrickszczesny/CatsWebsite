package com.sda.homework.cats.service;

import com.sda.homework.cats.dao.AccountDao;
import com.sda.homework.cats.entity.Account;
import java.util.List;

public class AccountService {

    private static AccountDao accountDao;

    public AccountService() {
        accountDao = new AccountDao();
    }

    public void save(Account account){
        accountDao.openCurrentSession();
        accountDao.save(account);
        accountDao.closeCurrentSession();
    }

    public void update(Account account){
        accountDao.openCurrentSession();
        accountDao.update(account);
        accountDao.closeCurrentSession();
    }

    public void delete(int id){
        accountDao.openCurrentSession();
        Account account = accountDao.findById(id);
        accountDao.delete(account);
        accountDao.closeCurrentSession();
    }

    public Account findById(int id){
        accountDao.openCurrentSession();
        Account account = accountDao.findById(id);
        accountDao.closeCurrentSession();
        return account;
    }

    public List<Account> findAll(){
        accountDao.openCurrentSession();
        List<Account> accountsList = accountDao.findAll();
        accountDao.closeCurrentSession();
        return accountsList;
    }

    public void deleteAll(){
        accountDao.openCurrentSession();
        accountDao.deleteAll();
        accountDao.closeCurrentSession();
    }

}
