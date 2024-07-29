package com.example.demo.Controllers;

import com.example.demo.Data.UserRepository;
import com.example.demo.Models.User;
import com.example.demo.Services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;


    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(value ="/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        kafkaProducerService.sendMessage("New user created: " + savedUser);
        return savedUser;
    }
}
