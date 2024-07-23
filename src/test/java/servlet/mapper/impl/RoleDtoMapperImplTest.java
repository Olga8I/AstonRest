package servlet.mapper.impl;


import org.example.model.Role;
import org.example.servlet.dto.RoleIncoming;
import org.example.servlet.dto.RoleOutGoing;
import org.example.servlet.dto.RoleUpdate;
import org.example.servlet.mapper.RoleDtoMapper;
import org.example.servlet.mapper.impl.RoleDtoMapperImpl;
import org.junit.jupiter.api.*;

import java.util.List;

class RoleDtoMapperImplTest {
    private static Role role;
    private static RoleIncoming roleIncomingDto;
    private static RoleUpdate roleUpdateDto;
    private static RoleOutGoing roleOutGoingDto;
    private RoleDtoMapper roleDtoMapper;

    @BeforeAll
    static void beforeAll() {
        role = new Role(
                10L,
                "Role for Test"
        );

        roleIncomingDto = new RoleIncoming(
                "Incoming dto"
        );

        roleUpdateDto = new RoleUpdate(
                100L,
                "Update dto"
        );
    }

    @BeforeEach
    void setUp() {
        roleDtoMapper = RoleDtoMapperImpl.getInstance();
    }

    @DisplayName("Role map(RoleIncomingDto")
    @Test
    void mapIncoming() {
        Role resultRole = roleDtoMapper.map(roleIncomingDto);

        Assertions.assertNull(resultRole.getId());
        Assertions.assertEquals(roleIncomingDto.getName(), resultRole.getName());
    }

    @DisplayName("Role map(RoleUpdateDto")
    @Test
    void testMapUpdate() {
        Role resultRole = roleDtoMapper.map(roleUpdateDto);

        Assertions.assertEquals(roleUpdateDto.getId(), resultRole.getId());
        Assertions.assertEquals(roleUpdateDto.getName(), resultRole.getName());
    }

    @DisplayName("RoleOutGoingDto map(Role")
    @Test
    void testMapOutgoing() {
        RoleOutGoing resultRole = roleDtoMapper.map(role);

        Assertions.assertEquals(role.getId(), resultRole.getId());
        Assertions.assertEquals(role.getName(), resultRole.getName());
    }


    @DisplayName("List<RoleOutGoingDto> map(List<Role> roleList")
    @Test
    void testMapList() {
        List<RoleOutGoing> resultList = roleDtoMapper.map(
                List.of(
                        role,
                        role,
                        role
                )
        );

        Assertions.assertEquals(3, resultList.size());
    }
}