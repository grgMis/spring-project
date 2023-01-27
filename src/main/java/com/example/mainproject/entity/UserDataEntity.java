package com.example.mainproject.entity;

import jakarta.persistence.*;

@Entity
public class UserDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_data_id;

    @Column(nullable = false, length = 40)
    private String user_data_login;

    @Column(nullable = false, length = 20)
    private String user_data_password;

    public UserDataEntity() {
    }

    public Integer getUser_data_id() {
        return user_data_id;
    }

    public void setUser_data_id(Integer user_data_id) {
        this.user_data_id = user_data_id;
    }

    public String getUser_data_login() {
        return user_data_login;
    }

    public void setUser_data_login(String user_data_login) {
        this.user_data_login = user_data_login;
    }

    public String getUser_data_password() {
        return user_data_password;
    }

    public void setUser_data_password(String user_data_password) {
        this.user_data_password = user_data_password;
    }
}
