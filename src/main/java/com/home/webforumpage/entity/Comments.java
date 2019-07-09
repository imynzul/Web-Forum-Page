package com.home.webforumpage.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments", schema = "web_forum")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long article_id;
    private String comments_content;
    private long user_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;
    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Articles article;

    public Comments() {
    }

    public Comments(long article_id, String comments_content, long user_id) {
        this.article_id = article_id;
        this.comments_content = comments_content;
        this.user_id = user_id;
    }

    public Comments(long id, long article_id, String comments_content, long user_id) {
        this.id = id;
        this.article_id = article_id;
        this.comments_content = comments_content;
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return id == comments.id &&
                article_id == comments.article_id &&
                user_id == comments.user_id &&
                Objects.equals(comments_content, comments.comments_content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, article_id, comments_content, user_id);
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", comments_content='" + comments_content + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public String getComments_content() {
        return comments_content;
    }

    public void setComments_content(String comments_content) {
        this.comments_content = comments_content;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Articles getArticle() {
        return article;
    }

    public void setArticle(Articles article) {
        this.article = article;
    }
}
