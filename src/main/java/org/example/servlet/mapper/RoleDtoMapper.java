package org.example.servlet.mapper;

import org.example.model.Role;
import org.example.servlet.dto.RoleIncoming;
import org.example.servlet.dto.RoleOutGoing;
import org.example.servlet.dto.RoleUpdate;

import java.util.List;

public interface RoleDtoMapper {
    Role map(RoleIncoming roleIncomingDto);

    Role map(RoleUpdate roleUpdateDto);

    RoleOutGoing map(Role role);

    List<RoleOutGoing> map(List<Role> roleList);
}
