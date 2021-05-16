package com.max.restApp.util;

import com.max.restApp.models.Account;
import com.max.restApp.models.Event;
import com.max.restApp.models.File;
import com.max.restApp.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionBuilder {
    private static Session session;

    private SessionBuilder(){
    }

    public static Session getSession() {
        if(session == null)
            openSession();
        return session;
    }

    public static Session refreshSession(){
        session.close();
        session = buildSessionFactory().openSession();
        return session;
    }

    public static void openSession(){
        session = buildSessionFactory().openSession();
    }

    public static void closeSession(){
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Event.class);
        configuration.addAnnotatedClass(File.class);
        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
