package com.max.restApp.repostories;

import com.max.restApp.models.Account;
import com.max.restApp.models.File;
import com.max.restApp.util.SessionBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountRepository implements GenericRepository<Account> {

    @Override
    public Account save(Account object) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return object;
    }

    @Override
    public Account update(Account object) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
        return object;
    }

    @Override
    public Account getById(Integer id) {
        Session session = SessionBuilder.getSession();
        Account object = session.get(Account.class, id);
        session.close();
        return object;
    }

    @Override
    public List<Account> getAll() {
        Session session = SessionBuilder.getSession();
        List<Account> objects = session.createQuery("from Account ").getResultList();
        session.close();
        return objects;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        Account object = new Account();
        object.setId(id);
        session.delete(object);
        transaction.commit();
        session.close();
    }
}