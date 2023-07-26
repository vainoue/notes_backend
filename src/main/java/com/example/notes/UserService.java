package com.example.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> singleUser(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
