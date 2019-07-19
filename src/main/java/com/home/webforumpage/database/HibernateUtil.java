package com.home.webforumpage.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Класс создает соединение при помощи Hibernate к БД
 * */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Метод создает сессию для связи с БД
     * */
    public static Session getSession(){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        return session;
    }

    /**
     * Метод закрывает сессию и выполняет commit транзакции
     * */
    public static void closeSession(Session session){
        if (session != null){
            session.getTransaction().commit();
            session.close();
        }
    }
}
