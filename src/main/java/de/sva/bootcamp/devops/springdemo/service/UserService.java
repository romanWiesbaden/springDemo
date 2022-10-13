package de.sva.bootcamp.devops.springdemo.service;

import de.sva.bootcamp.devops.springdemo.repository.User;
import de.sva.bootcamp.devops.springdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(String userId) {
        return userRepository.findById(userId);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        User createdUser = userRepository.save(user);

        return createdUser;
    }
}
