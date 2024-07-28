package org.example.servlet.dto;

public class RoleIncoming {
    private String name;
    public RoleIncoming() {

    }
    public RoleIncoming(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
