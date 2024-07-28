package org.example.servlet.dto;

import java.util.List;

public class UserUpdate {
    private Long id;
    private String firstName;
    private String lastName;
    private RoleUpdate role;
    private List<PhoneNumberUpdate> phoneNumberList;
    private List<DepartmentUpdate> departmentList;
    public UserUpdate() {

    }
    public UserUpdate(Long id, String firstName, String lastName, RoleUpdate role, List<PhoneNumberUpdate> phoneNumberList, List<DepartmentUpdate> departmentList) {
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

    public RoleUpdate getRole() {
        return role;
    }

    public List<PhoneNumberUpdate> getPhoneNumberList() {
        return phoneNumberList;
    }

    public List<DepartmentUpdate> getDepartmentList() {
        return departmentList;
    }
}


