package org.example.repository;

import org.example.model.Department;
import org.example.model.User;
import org.example.model.UserDepartment;
import java.util.List;
import java.util.Optional;

public interface UserToDepartmentRepository extends Repository<UserDepartment, Long> {
    boolean deleteByUserId(Long userId);

    boolean deleteByDepartmentId(Long departmentId);

    List<UserDepartment> findAllByUserId(Long userId);

    List<Department> findDepartmentsByUserId(Long userId);

    List<UserDepartment> findAllByDepartmentId(Long departmentId);

    List<User> findUsersByDepartmentId(Long departmentId);

    Optional<UserDepartment> findByUserIdAndDepartmentId(Long userId, Long departmentId);
}
