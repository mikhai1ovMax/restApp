package com.max.restApp.repostories;

import com.max.restApp.models.Account;
import com.max.restApp.models.Event;
import com.max.restApp.util.SessionBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EventRepository implements GenericRepository<Event> {
    private Session session;
    private Transaction transaction;

    public EventRepository(){
        session = SessionBuilder.getSession();
    }

    @Override
    public Event save(Event object) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return object;
    }

    @Override
    public Event update(Event object) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
        return object;
    }

    @Override
    public Event getById(Integer id) {
        Session session = SessionBuilder.getSession();
        Event object = session.get(Event.class, id);
        session.close();
        return object;
    }

    @Override
    public List<Event> getAll() {
        Session session = SessionBuilder.getSession();
        List<Event> objects = session.createQuery("from Event").getResultList();
        session.close();
        return objects;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        Event object = new Event();
        object.setId(id);
        session.delete(object);
        transaction.commit();
        session.close();
    }
}
