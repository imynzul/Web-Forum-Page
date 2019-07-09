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


    public UsersInfo getByEmail(String email){
        UsersInfo userInfo;
        try{
            Query<UsersInfo> query = session.createQuery("FROM UsersInfo WHERE email=:emailValue", UsersInfo.class);
            query.setParameter("emailValue", email);
            userInfo = query.getSingleResult();
        } catch (NoResultException e) {
            DAOException daoException = new DAOException(
                    "[Thread = " + Thread.currentThread().getName() +
                    "] tried to get UserInfo by Incorrect Email = " + email + ".", e);
            ExcLOGGER.error(daoException.getMessage(), daoException.getCause());
            userInfo = null;
        }
        return userInfo;
    }


    public List<UsersInfo> getAll(){
        Query<UsersInfo> query = session.createQuery("FROM UsersInfo", UsersInfo.class);
        List<UsersInfo> usersInfoList = query.list();

        return usersInfoList;
    }
}
