package com.home.webforumpage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_info", schema = "web_forum")
public class UsersInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long user_id;
    private String email;
    private int role;

    @JsonBackReference("users-info")
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    public UsersInfo() {
    }

    public UsersInfo(long user_id, String email) {
        this.user_id = user_id;
        this.email = email;
        this.role = 1;
    }

    public UsersInfo(long id, long user_id, String email, int role) {
        this.id = id;
        this.user_id = user_id;
        this.email = email;
        this.role = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersInfo usersInfo = (UsersInfo) o;
        return id == usersInfo.id &&
                user_id == usersInfo.user_id &&
                role == usersInfo.role &&
                Objects.equals(email, usersInfo.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, email, role);
    }

    @Override
    public String toString() {
        return "UsersInfo{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", email='" + email + '\'' +
                ", role=" + role +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
