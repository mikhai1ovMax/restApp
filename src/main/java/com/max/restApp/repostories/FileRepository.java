package com.max.restApp.repostories;

import com.max.restApp.models.File;
import com.max.restApp.util.SessionBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class FileRepository implements GenericRepository<File>{


    @Override
    public File save(File object) {
        Session session = SessionBuilder.getSession();
        object.setCreated(LocalDateTime.now());
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return object;
    }

    @Override
    public File update(File object) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
        return object;
    }

    @Override
    public File getById(Integer id) {
        Session session = SessionBuilder.getSession();
        File object = session.get(File.class, id);
        session.close();
        return object;
    }

    @Override
    public List<File> getAll() {
        Session session = SessionBuilder.getSession();
        List<File> files = session.createQuery("from File").getResultList();
        session.close();
        return files;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = SessionBuilder.getSession();
        Transaction transaction = session.beginTransaction();
        File object = new File();
        object.setId(id);
        session.delete(object);
        transaction.commit();
        session.close();
    }
}