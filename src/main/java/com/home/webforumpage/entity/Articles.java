package com.home.webforumpage.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "articles", schema = "web_forum")
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long user_id;
    private String topic;
    private String content;
    private Date data_issued;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    private List<Comments>commentsList;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "comments",
               joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<Users>usersViaOrders;

    public Articles() {
    }

    public Articles(String topic, String content, Date data_issued) {
        this.topic = topic;
        this.content = content;
        this.data_issued = Date.valueOf(LocalDate.now());
    }

    public Articles(long user_id, String topic, String content, Date data_issued) {
        this.user_id = user_id;
        this.topic = topic;
        this.content = content;
        this.data_issued = Date.valueOf(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articles articles = (Articles) o;
        return id == articles.id &&
                user_id == articles.user_id &&
                Objects.equals(topic, articles.topic) &&
                Objects.equals(content, articles.content) &&
                Objects.equals(data_issued, articles.data_issued);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, topic, content, data_issued);
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", data_issued=" + data_issued +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getData_issued() {
        return data_issued;
    }

    public void setData_issued(Date data_issued) {
        this.data_issued = data_issued;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<Users> getUsersViaOrders() {
        return usersViaOrders;
    }

    public void setUsersViaOrders(List<Users> usersViaOrders) {
        this.usersViaOrders = usersViaOrders;
    }
}

