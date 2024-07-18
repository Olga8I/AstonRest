package org.example.servlet.dto;

public class DepartmentUpdate {
    private Long id;
    private String name;

    public DepartmentUpdate(Long id, String name) {
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
