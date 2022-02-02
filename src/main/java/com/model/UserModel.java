package com.model;

import com.entity.UserEntity;

public class UserModel {
    private Long id;
    private String username;

    public static UserModel to_model(UserEntity userEntity)
    {
        UserModel user = new UserModel();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        return user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
