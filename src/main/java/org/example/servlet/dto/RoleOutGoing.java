package org.example.servlet.dto;

public class RoleOutGoing {
    private Long id;
    private String name;
    public RoleOutGoing() {

    }
    public RoleOutGoing(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

