package org.example.model;

/**
 * UserDepartment entity
 * ManyToMany
 * User <-> Department
 */
public class UserDepartment {
    private Long id;
    private Long userId;
    private Long departmentId;


    public UserDepartment(Long id, Long userId, Long departmentId) {
        this.id = id;
        this.userId = userId;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
