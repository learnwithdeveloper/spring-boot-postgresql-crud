package com.postgres.crud.services;

import com.postgres.crud.dao.UserRepository;
import com.postgres.crud.models.CreateUserRequest;
import com.postgres.crud.models.UpdateUserRequest;
import com.postgres.crud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    // C - Create
    // R - Read
    // U - Update
    // D - Delete

    public void createUser(CreateUserRequest userRequest) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUser(String id, UpdateUserRequest updateUserRequest) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User Not Found With Given Id : ".concat(id));
        }
        User user = optionalUser.get();
        if (!ObjectUtils.isEmpty(updateUserRequest.getName())) {
            user.setName(updateUserRequest.getName());
        }
        if (!ObjectUtils.isEmpty(updateUserRequest.getEmail())) {
            user.setEmail(updateUserRequest.getEmail());
        }
        userRepository.save(user);
    }

    public void deleteUser(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User Not Found With Given Id : ".concat(id));
        }
        userRepository.deleteById(id);
    }

}
