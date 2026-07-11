package com.example.demo;

//import com.example.demo.repository.userRepository;
import com.example.demo.entites.User;
import com.example.demo.repository.userRepository;
import com.example.demo.service.userService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServicesTests {

   @Autowired
    private userRepository userRepository;

   @Autowired
   private userService userService;


   @BeforeEach
   public void setUp() {

   }

   @Disabled("Uses real MongoDB Atlas")
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testFindByUsername(User user) {
        assertTrue(userService.saveNewEntry(user));
    }

    @Disabled
   @ParameterizedTest
   @CsvSource({"1,1,2",
               "2,10,12",
                "3,7,10"})
    public void test(int a,int b,int expected){
        assertEquals(expected,a+b);
    }
}
