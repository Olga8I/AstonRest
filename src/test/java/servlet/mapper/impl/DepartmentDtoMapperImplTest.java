package servlet.mapper.impl;

import org.example.model.Department;
import org.example.model.User;
import org.example.servlet.dto.DepartmentIncoming;
import org.example.servlet.dto.DepartmentOutGoing;
import org.example.servlet.dto.DepartmentUpdate;
import org.example.servlet.mapper.DepartmentDtoMapper;
import org.example.servlet.mapper.impl.DepartmentDtoMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class DepartmentDtoMapperImplTest {
    private DepartmentDtoMapper departmentDtoMapper;

    @BeforeEach
    void setUp() {
        departmentDtoMapper = DepartmentDtoMapperImpl.getInstance();
    }

    @DisplayName("Department map(DepartmentIncomingDto")
    @Test
    void mapIncoming() {
        DepartmentIncoming dto = new DepartmentIncoming("New Department");
        Department result = departmentDtoMapper.map(dto);

        Assertions.assertNull(result.getId());
        Assertions.assertEquals(dto.getName(), result.getName());
    }

    @DisplayName("DepartmentOutGoingDto map(Department")
    @Test
    void testMapOutgoing() {
        Department department = new Department(100L, "Department #100", List.of(new User(), new User()));

        DepartmentOutGoing result = departmentDtoMapper.map(department);

        Assertions.assertEquals(department.getId(), result.getId());
        Assertions.assertEquals(department.getName(), result.getName());
        Assertions.assertEquals(department.getUserList().size(), result.getUserList().size());
    }

    @DisplayName("Department map(DepartmentUpdateDto")
    @Test
    void testMapUpdate() {
        DepartmentUpdate dto = new DepartmentUpdate(10L, "Update name.");

        Department result = departmentDtoMapper.map(dto);
        Assertions.assertEquals(dto.getId(), result.getId());
        Assertions.assertEquals(dto.getName(), result.getName());
    }

    @DisplayName("List<DepartmentOutGoingDto> map(List<Department>")
    @Test
    void testMap2() {
        List<Department> departmentList = List.of(
                new Department(1L, "dep 1", List.of()),
                new Department(2L, "dep 2", List.of()),
                new Department(3L, "dep 3", List.of())
        );

        List<DepartmentOutGoing> result = departmentDtoMapper.map(departmentList);

        Assertions.assertEquals(3, result.size());
    }

    @DisplayName("List<Department> mapUpdateList(List<DepartmentUpdate>")
    @Test
    void mapUpdateList() {
        List<DepartmentUpdate> departmentList = List.of(
                new DepartmentUpdate(1L, "Update 1"),
                new DepartmentUpdate(2L, "Update 2"),
                new DepartmentUpdate(3L, "Update 3")
        );

        List<Department> result = departmentDtoMapper.mapUpdateList(departmentList);

        Assertions.assertEquals(3, result.size());
    }
}