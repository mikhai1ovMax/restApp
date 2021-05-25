package com.max.restApp.repostories;

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
        transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        return object;
    }

    @Override
    public Event update(Event object) {
        transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        return object;
    }

    @Override
    public Event getById(Integer id) {
        return session.get(Event.class, id);
    }

    @Override
    public List<Event> getAll() {
        return session.createQuery("from Account").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        transaction = session.beginTransaction();
        Event object = new Event();
        object.setId(id);
        session.delete(object);
        transaction.commit();
    }
}
