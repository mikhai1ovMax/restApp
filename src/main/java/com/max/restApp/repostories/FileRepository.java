package com.max.restApp.repostories;

import com.max.restApp.models.Event;
import com.max.restApp.models.File;
import com.max.restApp.util.SessionBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class FileRepository implements GenericRepository<File>{
    private Session session;
    private Transaction transaction;

    public FileRepository(){
        session = SessionBuilder.getSession();
    }

    @Override
    public File save(File object) {
        object.setCreated(LocalDateTime.now());
        transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        return object;
    }

    @Override
    public File update(File object) {
        transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        return object;
    }

    @Override
    public File getById(Integer id) {
        return session.get(File.class, id);
    }

    @Override
    public List<File> getAll() {
        return session.createQuery("from File").getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        transaction = session.beginTransaction();
        File object = new File();
        object.setId(id);
        session.delete(object);
        transaction.commit();
    }
}