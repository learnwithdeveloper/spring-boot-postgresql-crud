package com.postgres.crud.services;

import com.postgres.crud.dao.UserRepository;
import com.postgres.crud.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

    public UserResponse getAllUsers(UserSearchRequest userSearchRequest) {
        Sort sort = Sort.by(userSearchRequest.getSortKey());
        if (userSearchRequest.getSortValue().equalsIgnoreCase("asc")) {
            sort = sort.ascending();
        } else {
            sort = sort.descending();
        }

        Pageable pageable = PageRequest.of(userSearchRequest.getPage(), userSearchRequest.getSize(), sort);
//        Page<User> userData = userRepository.findAll(pageable);
        Page<User> userData = userRepository.searchUsersByNameAndEmail(
                userSearchRequest.getName(),
                userSearchRequest.getEmail(),
                pageable);
        return new UserResponse(userData.toList(), userData.getTotalElements());
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
