package org.example.service.impl;

import org.example.exception.NotFoundException;
import org.example.model.Department;
import org.example.model.UserDepartment;
import org.example.repository.DepartmentRepository;
import org.example.repository.UserRepository;
import org.example.repository.UserToDepartmentRepository;
import org.example.repository.impl.DepartmentRepositoryImpl;
import org.example.repository.impl.UserRepositoryImpl;
import org.example.repository.impl.UserToDepartmentRepositoryImpl;
import org.example.service.DepartmentService;
import org.example.servlet.dto.DepartmentIncoming;
import org.example.servlet.dto.DepartmentOutGoing;
import org.example.servlet.dto.DepartmentUpdate;
import org.example.servlet.mapper.DepartmentDtoMapper;
import org.example.servlet.mapper.impl.DepartmentDtoMapperImpl;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository = DepartmentRepositoryImpl.getInstance();
    private final UserRepository userRepository = UserRepositoryImpl.getInstance();
    private final UserToDepartmentRepository userToDepartmentRepository = UserToDepartmentRepositoryImpl.getInstance();
    private static final DepartmentDtoMapper departmentDtoMapper = DepartmentDtoMapperImpl.getInstance();
    private static DepartmentService instance;


    private DepartmentServiceImpl() {
    }

    public static synchronized DepartmentService getInstance() {
        if (instance == null) {
            instance = new DepartmentServiceImpl();
        }
        return instance;
    }

    private void checkExistDepartment(Long departmentId) throws NotFoundException {
        if (!departmentRepository.exitsById(departmentId)) {
            throw new NotFoundException("Department not found.");
        }
    }

    @Override
    public DepartmentOutGoing save(DepartmentIncoming departmentDto) {
        Department department = departmentDtoMapper.map(departmentDto);
        department = departmentRepository.save(department);
        return departmentDtoMapper.map(department);
    }

    @Override
    public void update(DepartmentUpdate departmentUpdateDto) throws NotFoundException {
        checkExistDepartment(departmentUpdateDto.getId());
        Department department = departmentDtoMapper.map(departmentUpdateDto);
        departmentRepository.update(department);
    }

    @Override
    public DepartmentOutGoing findById(Long departmentId) throws NotFoundException {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                new NotFoundException("Department not found."));
        return departmentDtoMapper.map(department);
    }

    @Override
    public List<DepartmentOutGoing> findAll() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentDtoMapper.map(departmentList);
    }

    @Override
    public void delete(Long departmentId) throws NotFoundException {
        checkExistDepartment(departmentId);
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public void deleteUserFromDepartment(Long departmentId, Long userId) throws NotFoundException {
        checkExistDepartment(departmentId);
        if (userRepository.exitsById(userId)) {
            UserDepartment linkUserDepartment = userToDepartmentRepository.findByUserIdAndDepartmentId(userId, departmentId)
                    .orElseThrow(() -> new NotFoundException("Link many to many Not found."));

            userToDepartmentRepository.deleteById(linkUserDepartment.getId());
        } else {
            throw new NotFoundException("User not found.");
        }

    }

    @Override
    public void addUserToDepartment(Long departmentId, Long userId) throws NotFoundException {
        checkExistDepartment(departmentId);
        if (userRepository.exitsById(userId)) {
            UserDepartment linkUserDepartment = new UserDepartment(
                    null,
                    userId,
                    departmentId
            );
            userToDepartmentRepository.save(linkUserDepartment);
        } else {
            throw new NotFoundException("User not found.");
        }
    }
}
