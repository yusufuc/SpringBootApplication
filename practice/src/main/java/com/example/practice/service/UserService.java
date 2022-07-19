package com.example.practice.service;

import com.example.practice.dao.UserRepository;
import com.example.practice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUser()
    {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id)
    {
        return userRepository.findById(id);
    }

    public User addUser(User user)
    {
        return userRepository.save(user);
    }

    public ResponseEntity<Object> deleteUser(Long userId) throws Exception {
        return userRepository.findById(userId).map(user -> {userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new Exception());
    }

    public User updateUser(Long userId,User userRequest) throws Exception {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setName(userRequest.getName());
                    user.setCity(userRequest.getCity());
                    user.setStatus(userRequest.getStatus());
                    user.setId(userRequest.getId());
                    return userRepository.save(user);
                }).orElseThrow(() -> new Exception("user not found with id " + userId));
    }

    @Autowired
    private WebClient.Builder webClientBuilder;
    public Mono<String> getEmployee()
    {
        return webClientBuilder.build()
                .get()
                .uri("https://reqres.in/api/users?page=2")
                .retrieve()
                .bodyToMono(String.class);
    }
}
