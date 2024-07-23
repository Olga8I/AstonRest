package org.example.service;

import org.example.exception.NotFoundException;
import org.example.servlet.dto.RoleIncoming;
import org.example.servlet.dto.RoleOutGoing;
import org.example.servlet.dto.RoleUpdate;

import java.util.List;

public interface RoleService {
    RoleOutGoing save(RoleIncoming role);

    void update(RoleUpdate role) throws NotFoundException;

    RoleOutGoing findById(Long roleId) throws NotFoundException;

    List<RoleOutGoing> findAll();

    boolean delete(Long roleId) throws NotFoundException;
}
