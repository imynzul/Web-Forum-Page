package com.home.webforumpage.dao;

import com.home.webforumpage.entity.Comments;
import org.hibernate.query.Query;

import java.util.List;

public class CommentsDao extends AbstractDao<Comments> {

    @Override
    public Comments get(long id){
        Comments comment = session.get(Comments.class, id);

        return comment;
    }

    public List<Comments> getAll(){
        List<Comments> commentsList;

        Query<Comments> query = session.createQuery("FROM Comments", Comments.class);
        commentsList = query.list();

        return commentsList;
    }
}
