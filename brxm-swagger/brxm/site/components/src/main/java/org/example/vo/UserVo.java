package org.example.vo;

import org.example.user.model.User;

public class UserVo {
    private Integer id;
    private String name;

    public UserVo (User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}