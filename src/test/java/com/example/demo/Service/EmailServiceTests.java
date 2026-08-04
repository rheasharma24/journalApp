package com.example.demo.Service;

import com.example.demo.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {


    @Autowired
    private EmailService emailService;

    @Test
    void sendEmail() {
        System.out.println("before sending......");
        emailService.sendEmail("btech60064.24bitmesra@gmail.com",
                "Testing java mail sender",
                "hello! how are you");
        System.out.println("after sending......");
    }

}
