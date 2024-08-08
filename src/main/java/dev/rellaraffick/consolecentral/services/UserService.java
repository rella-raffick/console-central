package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralUser;
import dev.rellaraffick.consolecentral.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(ConsoleCentralUser user) {
        userRepository.save(user);
    }

    public ConsoleCentralUser getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<ConsoleCentralUser> getAllUsers() {
        return  userRepository.findAll();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public ConsoleCentralUser updateUser(int id, ConsoleCentralUser user) {
        ConsoleCentralUser existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUserName(user.getUserName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setCreatedDate(user.getCreatedDate());
            userRepository.save(existingUser);
        }
        return existingUser;
    }

    public void authenticateUser(String email, String password) {
        ConsoleCentralUser user = userRepository.findByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                System.out.println("User authenticated");
            } else {
                System.out.println("Invalid password");
            }
        } else {
            System.out.println("User not found");
        }
    }
}
