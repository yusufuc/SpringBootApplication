package com.example.practice.controller;

import com.example.practice.dao.UserRepository;
import com.example.practice.entities.User;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Iterable<User> getUser()
    {
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User addUser(@Validated @RequestBody User user)
    {
        return userService.addUser(user);

    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long userId) throws Exception {
        return userService.deleteUser(userId);
    }

    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable Long userId,
                                   @Validated @RequestBody User userRequest) throws Exception {
        return userService.updateUser(userId,userRequest);
    }

    //-------------------------------------

    //how to fetch data from different api
    @GetMapping("/getEmployees")
    public Mono<String> getEmployee() {
        return userService.getEmployee();
    }
}
