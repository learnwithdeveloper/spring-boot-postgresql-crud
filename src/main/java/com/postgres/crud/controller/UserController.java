package com.postgres.crud.controller;

import com.postgres.crud.models.CreateUserRequest;
import com.postgres.crud.models.UpdateUserRequest;
import com.postgres.crud.models.User;
import com.postgres.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest userRequest) {
        userService.createUser(userRequest);
        return ResponseEntity.ok().body("User Created Successfully");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody UpdateUserRequest userRequest) {
        userService.updateUser(id, userRequest);
        return ResponseEntity.ok().body("User Update Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String usersId) {
        userService.deleteUser(usersId);
        return ResponseEntity.ok().body("User Deleted Successfully");
    }

}
