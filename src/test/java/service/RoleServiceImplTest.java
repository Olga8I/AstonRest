package service;

import org.example.exception.NotFoundException;
import org.example.model.Role;
import org.example.repository.RoleRepository;
import org.example.repository.impl.RoleRepositoryImpl;
import org.example.service.RoleService;
import org.example.service.impl.RoleServiceImpl;
import org.example.servlet.dto.RoleIncoming;
import org.example.servlet.dto.RoleOutGoing;
import org.example.servlet.dto.RoleUpdate;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Optional;

class RoleServiceImplTest {
    private static RoleService roleService;
    private static RoleRepository mockRoleRepository;
    private static RoleRepositoryImpl oldInstance;

    private static void setMock(RoleRepository mock) {
        try {
            Field instance = RoleRepositoryImpl.class.getDeclaredField("instance");
            instance.setAccessible(true);
            oldInstance = (RoleRepositoryImpl) instance.get(instance);
            instance.set(instance, mock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeAll
    static void beforeAll() {
        mockRoleRepository = Mockito.mock(RoleRepository.class);
        setMock(mockRoleRepository);
        roleService = RoleServiceImpl.getInstance();
    }

    @AfterAll
    static void afterAll() throws Exception {
        Field instance = RoleRepositoryImpl.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(instance, oldInstance);
    }

    @BeforeEach
    void setUp() {
        Mockito.reset(mockRoleRepository);
    }

    @Test
    void save() {
        Long expectedId = 1L;

        RoleIncoming dto = new RoleIncoming("role #2");
        Role role = new Role(expectedId, "role #10");

        Mockito.doReturn(role).when(mockRoleRepository).save(Mockito.any(Role.class));

        RoleOutGoing result = roleService.save(dto);

        Assertions.assertEquals(expectedId, result.getId());
    }

    @Test
    void update() throws NotFoundException {
        Long expectedId = 1L;

        RoleUpdate dto = new RoleUpdate(expectedId, "role update #1");

        Mockito.doReturn(true).when(mockRoleRepository).exitsById(Mockito.any());

        roleService.update(dto);

        ArgumentCaptor<Role> argumentCaptor = ArgumentCaptor.forClass(Role.class);
        Mockito.verify(mockRoleRepository).update(argumentCaptor.capture());

        Role result = argumentCaptor.getValue();
        Assertions.assertEquals(expectedId, result.getId());
    }

    @Test
    void updateNotFound() {
        RoleUpdate dto = new RoleUpdate(1L, "role update #1");

        Mockito.doReturn(false).when(mockRoleRepository).exitsById(Mockito.any());

        NotFoundException exception = Assertions.assertThrows(
                NotFoundException.class,
                () -> {
                    roleService.update(dto);
                }, "Not found."
        );
        Assertions.assertEquals("Role not found.", exception.getMessage());
    }

    @Test
    void findById() throws NotFoundException {
        Long expectedId = 1L;

        Optional<Role> role = Optional.of(new Role(expectedId, "role found #1"));

        Mockito.doReturn(true).when(mockRoleRepository).exitsById(Mockito.any());
        Mockito.doReturn(role).when(mockRoleRepository).findById(Mockito.anyLong());

        RoleOutGoing dto = roleService.findById(expectedId);

        Assertions.assertEquals(expectedId, dto.getId());
    }

    @Test
    void findByIdNotFound() {
        Optional<Role> role = Optional.empty();

        Mockito.doReturn(false).when(mockRoleRepository).exitsById(Mockito.any());

        NotFoundException exception = Assertions.assertThrows(
                NotFoundException.class,
                () -> {
                    roleService.findById(1L);
                }, "Not found."
        );
        Assertions.assertEquals("Role not found.", exception.getMessage());
    }

    @Test
    void findAll() {
        roleService.findAll();
        Mockito.verify(mockRoleRepository).findAll();
    }

    @Test
    void delete() throws NotFoundException {
        Long expectedId = 100L;

        Mockito.doReturn(true).when(mockRoleRepository).exitsById(100L);

        roleService.delete(expectedId);

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(mockRoleRepository).deleteById(argumentCaptor.capture());

        Long result = argumentCaptor.getValue();
        Assertions.assertEquals(expectedId, result);
    }
}