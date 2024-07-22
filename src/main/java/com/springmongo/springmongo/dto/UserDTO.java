package com.springmongo.springmongo.dto;

import com.springmongo.springmongo.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String id;
    @NotBlank(message = "name cannot be blank")
    @Size(min = 3, max = 10, message = "name have to be between 3 and 10")
    private String name;
    @NotBlank
    @Email
    private String email;

    public UserDTO (User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public UserDTO(){}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
