package org.example.servlet.dto;

import java.util.List;

public class DepartmentOutGoing {
    private Long id;
    private String name;
    private List<UserSmallOutGoingDto> userList;

    public DepartmentOutGoing(Long id, String name, List<UserSmallOutGoingDto> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserSmallOutGoingDto> getUserList() {
        return userList;
    }

    public void setUserList(List<UserSmallOutGoingDto> userList) {
        this.userList = userList;
    }
}
