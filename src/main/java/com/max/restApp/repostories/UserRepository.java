package com.max.restApp.repostories;

import com.max.restApp.models.Account;
import com.max.restApp.models.User;
import com.max.restApp.util.SessionBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepository implements GenericRepository<User> {
    private Session session;
    private Transaction transaction;

    public UserRepository() {
        session = SessionBuilder.getSession();
    }

    @Override
    public User save(User object) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return object;
    }

    @Override
    public User update(User object) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
        return object;
    }

    @Override
    public User getById(Integer id) {
        Session session = SessionBuilder.getSession();
        User object = session.get(User.class, id);
        session.close();
        return object;
    }

    @Override
    public List<User> getAll() {
        Session session = SessionBuilder.getSession();
        List<User> objects = session.createQuery("from User ").getResultList();
        session.close();
        return objects;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        User object = new User();
        object.setId(id);
        session.delete(object);
        transaction.commit();
        session.close();
    }
}
