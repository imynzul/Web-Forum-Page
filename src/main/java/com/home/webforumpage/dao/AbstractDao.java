package com.home.webforumpage.dao;

import com.home.webforumpage.database.HibernateUtil;
import com.home.webforumpage.exceptions.DAOException;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public abstract class AbstractDao<T> {

    protected Session session;
    protected static final Logger DBLOGGER = Logger.getLogger("DBChangesLogger");
    protected static final Logger ExcLOGGER = Logger.getLogger("ExceptionLogger");

    AbstractDao(){
        session = HibernateUtil.getSession();
    }

    public abstract T get(long id);

    public long insert(T ob){
        DBLOGGER.info("[Thread = "+ Thread.currentThread().getName() + "] inserted new User = " + ob.toString() + ".");
        return (long)session.save(ob);
    }

    public void update(T ob){
        DBLOGGER.info("[Thread = "+ Thread.currentThread().getName() + "] updated existing User  = " + ob.toString() + ".");
        session.update(ob);
    }

    public void delete(T ob){
        DBLOGGER.info("[Thread = "+ Thread.currentThread().getName() + "] deleted existing User  = " + ob.toString() + ".");
        session.delete(ob);
    }

    public void closeCurrentSession() {  HibernateUtil.closeSession(session); }

}
