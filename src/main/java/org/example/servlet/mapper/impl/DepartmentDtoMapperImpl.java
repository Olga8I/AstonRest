package org.example.servlet.mapper.impl;

import org.example.model.Department;
import org.example.servlet.dto.DepartmentIncoming;
import org.example.servlet.dto.DepartmentOutGoing;
import org.example.servlet.dto.DepartmentUpdate;
import org.example.servlet.dto.UserSmallOutGoingDto;
import org.example.servlet.mapper.DepartmentDtoMapper;

import java.util.List;

public class DepartmentDtoMapperImpl implements DepartmentDtoMapper {
    private static DepartmentDtoMapper instance;

    private DepartmentDtoMapperImpl() {
    }

    public static synchronized DepartmentDtoMapper getInstance() {
        if (instance == null) {
            instance = new DepartmentDtoMapperImpl();
        }
        return instance;
    }

    @Override
    public Department map(DepartmentIncoming dto) {
        return new Department(
                null,
                dto.getName(),
                null
        );
    }

    @Override
    public DepartmentOutGoing map(Department department) {
        List<UserSmallOutGoingDto> userList = department.getUserList()
                .stream().map(user -> new UserSmallOutGoingDto(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName()
                )).toList();

        return new DepartmentOutGoing(
                department.getId(),
                department.getName(),
                userList
        );
    }

    @Override
    public Department map(DepartmentUpdate updateDto) {
        return new Department(
                updateDto.getId(),
                updateDto.getName(),
                null
        );
    }

    @Override
    public List<DepartmentOutGoing> map(List<Department> departmentList) {
        return departmentList.stream().map(this::map).toList();
    }

    @Override
    public List<Department> mapUpdateList(List<DepartmentUpdate> departmentList) {
        return departmentList.stream().map(this::map).toList();
    }
}
