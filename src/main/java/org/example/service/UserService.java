package org.example.service;

import org.example.exception.NotFoundException;
import org.example.servlet.dto.UserIncoming;
import org.example.servlet.dto.UserOutGoing;
import org.example.servlet.dto.UserUpdate;

import java.util.List;

public interface UserService {
    UserOutGoing save(UserIncoming userDto);

    void update(UserUpdate userDto) throws NotFoundException;

    UserOutGoing findById(Long userId) throws NotFoundException;

    List<UserOutGoing> findAll();

    void delete(Long userId) throws NotFoundException;
}
