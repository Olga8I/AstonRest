package org.example.service;

import org.example.exception.NotFoundException;
import org.example.servlet.dto.DepartmentIncoming;
import org.example.servlet.dto.DepartmentOutGoing;
import org.example.servlet.dto.DepartmentUpdate;

import java.util.List;

public interface DepartmentService {
    DepartmentOutGoing save(DepartmentIncoming department);

    void update(DepartmentUpdate department) throws NotFoundException;

    DepartmentOutGoing findById(Long departmentId) throws NotFoundException;

    List<DepartmentOutGoing> findAll();

    void delete(Long departmentId) throws NotFoundException;

    void deleteUserFromDepartment(Long departmentId, Long userId) throws NotFoundException;

    void addUserToDepartment(Long departmentId, Long userId) throws NotFoundException;
}
