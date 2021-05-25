package com.max.restApp.repostories;

import com.max.restApp.models.Account;
import com.max.restApp.util.SessionBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountRepository implements GenericRepository<Account>{
    private Session session;
    private Transaction transaction;

    public AccountRepository(){
        session = SessionBuilder.getSession();
    }

    @Override
    public Account save(Account object) {
        transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        return object;
    }

    @Override
    public Account update(Account object) {
        transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        return object;
    }

    @Override
    public Account getById(Integer id) {
        return session.get(Account.class, id);
    }

    @Override
    public List<Account> getAll() {
        return session.createQuery("from Account").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        transaction = session.beginTransaction();
        Account object = new Account();
        object.setId(id);
        session.delete(object);
        transaction.commit();
    }
}