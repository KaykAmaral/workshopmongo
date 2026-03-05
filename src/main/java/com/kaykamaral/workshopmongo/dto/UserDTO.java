package com.kaykamaral.workshopmongo.dto;

import com.kaykamaral.workshopmongo.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO() {}
    public UserDTO(User user) {
        id = user.getId(); name = user.getName(); email = user.getEmail();
    }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }



}