package org.example.servlet.dto;

import org.example.model.Role;

public class UserIncoming {
    private String firstName;
    private String lastName;

    private Role role;

    public UserIncoming(String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

}


