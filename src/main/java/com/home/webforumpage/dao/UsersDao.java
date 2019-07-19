package com.home.webforumpage.dao;

import com.home.webforumpage.entity.Users;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class UsersDao extends AbstractDao<Users> {


   @Override
   public Users get(long id){
       Users user = session.get(Users.class, id);

       return user;
   }


   /**
    * Метод возвращает пользователя по его логину
    *
    * @return Users user
    * */
   public Users getByLogin(String login){
       Users user;
       try{
           Query<Users>query = session.createQuery("FROM Users WHERE login=:loginValue", Users.class);
           query.setParameter("loginValue", login);
           user = query.getSingleResult();
       } catch (NoResultException e){
           user = null;
       }
       return user;
    }


    /**
     * Метод возвращает список всех пользователей
     *
     * @return List<Users> userList
     * */
   public List<Users> getAll(){
       Query<Users> query = session.createQuery("FROM Users", Users.class);
       List<Users> usersList = query.list();

       return usersList;
    }
}
