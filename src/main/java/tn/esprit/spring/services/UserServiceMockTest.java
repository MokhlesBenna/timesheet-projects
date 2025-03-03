package tn.esprit.spring.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepositoryMock;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceMockTest {

    @Mock
    private UserRepositoryMock userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testAddUser() {
        User user = new User("testUser", "testEmail@example.com");
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.addUser(user);

        assertNotNull(result);
        assertEquals("testUser", result.getLastName());
    }

    @Test
    public void testUpdateUser() {
        User user = new User("testUser", "testEmail@example.com");
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.updateUser(user);

        assertEquals("testUser", result.getLastName());
    }

    @Test
    public void testDeleteUser() {
        User user = new User("testUser", "testEmail@example.com");

        doNothing().when(userRepository).delete(user);

        assertDoesNotThrow(() -> userService.deleteUser(user));
    }

    @Test
    public void testRetrieveUser() {
        User user = new User("testUser", "testEmail@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.retrieveUser(1L);

        assertNotNull(result);
        assertEquals("testUser", result.getLastName());
    }
}
