package tn.esprit.spring.repository;


import tn.esprit.spring.entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryMock {
    private Map<Long, User> users = new HashMap<>();
    private Long nextId = 1L;

    public User save(User user) {
        if (user.getId() == null) {
            user = new User(user.getLastName(), "testEmail@example.com");
            users.put(nextId, user);
            nextId++;
        } else {
            users.put(user.getId(), user);
        }
        return user;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public void delete(User user) {
        users.remove(user.getId());
    }
}
