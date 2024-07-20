package org.example.servlet.mapper;

import org.example.model.Department;
import org.example.servlet.dto.DepartmentIncoming;
import org.example.servlet.dto.DepartmentOutGoing;
import org.example.servlet.dto.DepartmentUpdate;

import java.util.List;

public interface DepartmentDtoMapper {
    Department map(DepartmentIncoming departmentIncomingDto);

    DepartmentOutGoing map(Department department);

    Department map(DepartmentUpdate departmentUpdateDto);

    List<DepartmentOutGoing> map(List<Department> departmentList);

    List<Department> mapUpdateList(List<DepartmentUpdate> departmentList);
}
