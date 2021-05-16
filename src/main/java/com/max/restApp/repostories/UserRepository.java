package com.max.restApp.repostories;

import com.max.restApp.models.User;
import com.max.restApp.util.SessionBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepository implements GenericRepository<User> {
    private Session session;
    private Transaction transaction;

    public UserRepository(){
        session = SessionBuilder.getSession();
    }

    @Override
    public User save(User object) {
        transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        return object;
    }

    @Override
    public User update(User object) {
        transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        return object;
    }

    @Override
    public User getById(Integer id) {
        return session.get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return session.createQuery("from User").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        transaction = session.beginTransaction();
        User user = new User();
        user.setId(id);
        session.delete(user);
        transaction.commit();
    }
}
