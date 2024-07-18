package org.example.servlet.mapper;

import org.example.model.User;
import org.example.servlet.dto.UserIncoming;
import org.example.servlet.dto.UserOutGoing;
import org.example.servlet.dto.UserUpdate;

import java.util.List;

public interface UserDtoMapper {
    User map(UserIncoming userIncomingDto);

    User map(UserUpdate userIncomingDto);

    UserOutGoing map(User user);

    List<UserOutGoing> map(List<User> user);

}
