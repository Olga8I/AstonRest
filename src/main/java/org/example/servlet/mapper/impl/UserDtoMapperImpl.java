package org.example.servlet.mapper.impl;

import org.example.model.User;
import org.example.servlet.dto.UserIncoming;
import org.example.servlet.dto.UserOutGoing;
import org.example.servlet.dto.UserUpdate;
import org.example.servlet.mapper.DepartmentDtoMapper;
import org.example.servlet.mapper.PhoneNumberDtoMapper;
import org.example.servlet.mapper.RoleDtoMapper;
import org.example.servlet.mapper.UserDtoMapper;

import java.util.List;

public class UserDtoMapperImpl implements UserDtoMapper {
    private static final RoleDtoMapper roleDtoMapper = RoleDtoMapperImpl.getInstance();
    private static final PhoneNumberDtoMapper phoneNumberDtoMapper = PhoneNumberDtoMapperImpl.getInstance();
    private static final DepartmentDtoMapper departmentDtoMapper = DepartmentDtoMapperImpl.getInstance();


    private static UserDtoMapper instance;

    private UserDtoMapperImpl() {
    }

    public static synchronized UserDtoMapper getInstance() {
        if (instance == null) {
            instance = new UserDtoMapperImpl();
        }
        return instance;
    }

    @Override
    public User map(UserIncoming userDto) {
        return new User(
                null,
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getRole(),
                null,
                null
        );
    }

    @Override
    public User map(UserUpdate userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                roleDtoMapper.map(userDto.getRole()),
                phoneNumberDtoMapper.mapUpdateList(userDto.getPhoneNumberList()),
                departmentDtoMapper.mapUpdateList(userDto.getDepartmentList())
        );
    }

    @Override
    public UserOutGoing map(User user) {
        return new UserOutGoing(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                roleDtoMapper.map(user.getRole()),
                phoneNumberDtoMapper.map(user.getPhoneNumberList()),
                departmentDtoMapper.map(user.getDepartmentList())
        );
    }

    @Override
    public List<UserOutGoing> map(List<User> user) {
        return user.stream().map(this::map).toList();
    }
}
