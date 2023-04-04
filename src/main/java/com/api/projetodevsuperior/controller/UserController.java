package com.api.projetodevsuperior.controller;

import com.api.projetodevsuperior.model.User;
import com.api.projetodevsuperior.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("No user found with id: "+ id.toString()));
    }
    @PostMapping
    public User insert(@RequestBody User user){
        return userRepository.save(user);
    }
}
