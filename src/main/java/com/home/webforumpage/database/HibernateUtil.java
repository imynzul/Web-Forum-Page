package com.home.webforumpage.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static Session getSession(){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        return session;
    }

    public static void closeSession(Session session){
        if (session != null){
            session.getTransaction().commit();
            session.close();
        }
    }
}
