package tn.esprit.spring.services;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> retrieveAllUsers() {
		return null;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(String id) {

	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User retrieveUser(String id) {
		return null;
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public User retrieveUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}
}
