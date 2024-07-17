package com.springmongo.springmongo.dto;

import com.springmongo.springmongo.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private String id;
    private String name;

    public AuthorDTO (User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public AuthorDTO(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
