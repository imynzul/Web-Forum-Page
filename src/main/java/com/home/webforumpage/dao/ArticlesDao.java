package com.home.webforumpage.dao;

import com.home.webforumpage.entity.Articles;
import com.home.webforumpage.exceptions.DAOException;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class ArticlesDao extends AbstractDao<Articles> {

    @Override
    public Articles get(long id){
        Articles article = session.get(Articles.class, id);
        return article;
    }

    public List<Articles> getByUserId(long userId){
        List<Articles> article;
        try{
            Query<Articles> query = session.createQuery("FROM Articles WHERE user_id=:userId", Articles.class);
            query.setParameter("userId", userId);
            article = query.list();
        } catch (NoResultException e) {
            DAOException daoException = new DAOException(
                    "[Thread = " + Thread.currentThread().getName() +
                    "] tried to get List of Articles by Incorrect UserId = " + userId + ".", e);
            ExcLOGGER.error(daoException.getMessage(), daoException.getCause());
            article = null;
        }
        return article;
    }

    public List<Articles> getAll(){
        List<Articles>articleList;

        Query<Articles> query = session.createQuery("FROM Articles", Articles.class);
        articleList = query.list();

        return articleList;
    }
}
