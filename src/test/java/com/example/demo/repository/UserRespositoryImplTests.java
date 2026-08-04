package com.example.demo.repository;

import com.example.demo.entites.User;
import com.example.demo.service.userService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRespositoryImplTests {


    @Autowired
    private UserRespositoryImpl userRespository;

   @Test
    public void testSaveNewUser(){
        Assertions.assertNotNull(userRespository.getUserforSA());
    }
}
