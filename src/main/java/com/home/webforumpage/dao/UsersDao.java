package com.home.webforumpage.dao;

import com.home.webforumpage.entity.Users;
import com.home.webforumpage.exceptions.DAOException;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class UsersDao extends AbstractDao<Users> {


    @Override
   public Users get(long id){
       Users user = session.get(Users.class, id);

       return user;
   }


   public Users getByLogin(String login){
       Users user;
       try{
           Query<Users>query = session.createQuery("FROM Users WHERE login=:loginValue", Users.class);
           query.setParameter("loginValue", login);
           user = query.getSingleResult();
       } catch (NoResultException e){
           DAOException daoException = new DAOException(
                   "[Thread = " + Thread.currentThread().getName() +
                   "] tried to get User by Incorrect Login = " + login + ".", e);
           ExcLOGGER.error(daoException.getMessage(), daoException.getCause());
           user = null;
       }
       return user;
    }


   public List<Users> getAll(){
       Query<Users> query = session.createQuery("FROM Users", Users.class);
       List<Users> usersList = query.list();

       return usersList;
    }
}
