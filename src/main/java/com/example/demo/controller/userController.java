package com.example.demo.controller;

import com.example.demo.entites.User;


import com.example.demo.repository.userRepository;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userService;
    @Autowired
    private userRepository userRepository;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAll();
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User userInDb = userService.findByUsername(username);
        if(userInDb != null){
            if(user.getUsername()!=null) {
                userInDb.setUsername(user.getUsername());
            }
            if(user.getPassword()!=null) {
                userInDb.setPassword(user.getPassword());
                userService.saveUser(userInDb);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> deleteUser(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUsername(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
