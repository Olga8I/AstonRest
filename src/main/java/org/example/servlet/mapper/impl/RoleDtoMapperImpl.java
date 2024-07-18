package org.example.servlet.mapper.impl;

import org.example.model.Role;
import org.example.servlet.dto.RoleIncoming;
import org.example.servlet.dto.RoleOutGoing;
import org.example.servlet.dto.RoleUpdate;
import org.example.servlet.mapper.RoleDtoMapper;

import java.util.List;

public class RoleDtoMapperImpl implements RoleDtoMapper {
    private static RoleDtoMapper instance;

    private RoleDtoMapperImpl() {
    }

    public static synchronized RoleDtoMapper getInstance() {
        if (instance == null) {
            instance = new RoleDtoMapperImpl();
        }
        return instance;
    }

    @Override
    public Role map(RoleIncoming roleIncomingDto) {
        return new Role(
                null,
                roleIncomingDto.getName()
        );
    }

    @Override
    public Role map(RoleUpdate roleUpdateDto) {
        return new Role(
                roleUpdateDto.getId(),
                roleUpdateDto.getName());
    }

    @Override
    public RoleOutGoing map(Role role) {
        return new RoleOutGoing(
                role.getId(),
                role.getName()
        );
    }

    @Override
    public List<RoleOutGoing> map(List<Role> roleList) {
        return roleList.stream().map(this::map).toList();
    }
}
