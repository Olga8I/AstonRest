package org.example.service.impl;

import org.example.exception.NotFoundException;
import org.example.model.Role;
import org.example.repository.RoleRepository;
import org.example.repository.impl.RoleRepositoryImpl;
import org.example.service.RoleService;
import org.example.servlet.dto.RoleIncoming;
import org.example.servlet.dto.RoleOutGoing;
import org.example.servlet.dto.RoleUpdate;
import org.example.servlet.mapper.RoleDtoMapper;
import org.example.servlet.mapper.impl.RoleDtoMapperImpl;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository = RoleRepositoryImpl.getInstance();
    private static RoleService instance;
    private final RoleDtoMapper roleDtoMapper = RoleDtoMapperImpl.getInstance();


    private RoleServiceImpl() {
    }

    public static synchronized RoleService getInstance() {
        if (instance == null) {
            instance = new RoleServiceImpl();
        }
        return instance;
    }

    @Override
    public RoleOutGoing save(RoleIncoming roleDto) {
        Role role = roleDtoMapper.map(roleDto);
        role = roleRepository.save(role);
        return roleDtoMapper.map(role);
    }

    @Override
    public void update(RoleUpdate roleUpdateDto) throws NotFoundException {
        checkRoleExist(roleUpdateDto.getId());
        Role role = roleDtoMapper.map(roleUpdateDto);
        roleRepository.update(role);
    }

    @Override
    public RoleOutGoing findById(Long roleId) throws NotFoundException {
        Role role = roleRepository.findById(roleId).orElseThrow(() ->
                new NotFoundException("Role not found."));
        return roleDtoMapper.map(role);
    }

    @Override
    public List<RoleOutGoing> findAll() {
        List<Role> roleList = roleRepository.findAll();
        return roleDtoMapper.map(roleList);
    }

    @Override
    public boolean delete(Long roleId) throws NotFoundException {
        checkRoleExist(roleId);
        return roleRepository.deleteById(roleId);
    }

    private void checkRoleExist(Long roleId) throws NotFoundException {
        if (!roleRepository.exitsById(roleId)) {
            throw new NotFoundException("Role not found.");
        }
    }
}
