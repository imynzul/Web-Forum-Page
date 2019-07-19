package com.home.webforumpage.dao;

import com.home.webforumpage.entity.UsersInfo;
import com.home.webforumpage.exceptions.DAOException;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class UsersInfoDao extends AbstractDao<UsersInfo>{

    @Override
    public UsersInfo get(long id){
        UsersInfo userInfo = session.get(UsersInfo.class, id);
        return userInfo;
    }


    /**
     * Метод возвращает инфо о пользователе по его email
     *
     * @return UsersInfo userInfo
     * */
    public UsersInfo getByEmail(String email){
        UsersInfo userInfo;
        try{
            Query<UsersInfo> query = session.createQuery("FROM UsersInfo WHERE email=:emailValue", UsersInfo.class);
            query.setParameter("emailValue", email);
            userInfo = query.getSingleResult();
        } catch (NoResultException e) {
            userInfo = null;
        }
        return userInfo;
    }


    /**
     * Метод возвращает всю информацию о пользователях
     *
     * @return List<UsersInfo> usersInfoList
     * */
    public List<UsersInfo> getAll(){
        Query<UsersInfo> query = session.createQuery("FROM UsersInfo", UsersInfo.class);
        List<UsersInfo> usersInfoList = query.list();

        return usersInfoList;
    }
}
