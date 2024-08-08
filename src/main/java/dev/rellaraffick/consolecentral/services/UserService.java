package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralUser;
import dev.rellaraffick.consolecentral.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ConsoleCentralUser createUser(ConsoleCentralUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<ConsoleCentralUser> getUserById(int id) {
        return userRepository.findById(id);
    }

    public List<ConsoleCentralUser> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean deleteUser(int id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
            return false;
        }
    }

    @Transactional
    public Optional<ConsoleCentralUser> updateUser(int id, ConsoleCentralUser user) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setUserName(user.getUserName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(passwordEncoder.encode(user.getPassword())); // Updating with encoded password
            existingUser.setCreatedDate(user.getCreatedDate());
            return userRepository.save(existingUser);
        });
    }
}
