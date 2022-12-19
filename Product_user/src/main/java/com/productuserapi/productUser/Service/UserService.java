package com.productuserapi.productUser.Service;

import com.productuserapi.productUser.Entity.User;
import com.productuserapi.productUser.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public  Optional<User> getUserID(Integer id) {
        return userRepository.findById(id);
    }
    public void saveNewUser(User user) {
        userRepository.save(user);
    }

    public User editUser(User user) {
        return userRepository.save(user);
    }
}
