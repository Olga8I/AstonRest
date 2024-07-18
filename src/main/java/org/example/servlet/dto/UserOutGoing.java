package org.example.servlet.dto;

import java.util.List;

public class UserOutGoing {
    private Long id;
    private String firstName;
    private String lastName;

    private RoleOutGoing role;
    private List<PhoneNumberOutGoing> phoneNumberList;
    private List<DepartmentOutGoing> departmentList;


    public UserOutGoing(Long id, String firstName, String lastName, RoleOutGoing role, List<PhoneNumberOutGoing> phoneNumberList, List<DepartmentOutGoing> departmentList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.phoneNumberList = phoneNumberList;
        this.departmentList = departmentList;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public RoleOutGoing getRole() {
        return role;
    }


    public List<PhoneNumberOutGoing> getPhoneNumberList() {
        return phoneNumberList;
    }

    public List<DepartmentOutGoing> getDepartmentList() {
        return departmentList;
    }

}

