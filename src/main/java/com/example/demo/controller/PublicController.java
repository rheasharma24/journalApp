package com.example.demo.controller;


import com.example.demo.DTO.UserSignupDTO;
import com.example.demo.DTO.UserloginDTO;
import com.example.demo.entites.User;
import com.example.demo.service.UserDetailsServiceImpl;
import com.example.demo.service.userService;
import com.example.demo.utilis.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private userService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    public PublicController() {
        System.out.println("PublicController Loaded");
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }

    @PostMapping("/signup")
    public void signup(@RequestBody UserSignupDTO userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(List.of("USER"));
        userService.saveNewEntry(user);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserloginDTO userDto) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername());
              String jwt = jwtUtil.generateToken(userDetails.getUsername());
              return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (Exception e) {
           log.error("Exception occurred while createAuthenticationToken",e);
           return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
        }

    }
}
