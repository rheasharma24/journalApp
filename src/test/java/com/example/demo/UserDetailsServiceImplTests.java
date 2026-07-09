package com.example.demo;

import com.example.demo.entites.User;
import com.example.demo.repository.userRepository;
import com.example.demo.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
//import org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ActiveProfiles("dev")
public class UserDetailsServiceImplTests {

   @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private userRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsername(){
        when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("shyam").password("vjhjnbjn").roles(new ArrayList<>()).build());
        UserDetails user=userDetailsService.loadUserByUsername("shyam");
        Assertions.assertNotNull(user);
    }
}
