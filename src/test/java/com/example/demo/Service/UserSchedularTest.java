package com.example.demo.Service;


import com.example.demo.Scheduler.UserScheduler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedularTest {

    @Autowired
    private UserScheduler userScheduler;

    @Test
    public void testFetchUsersAndSchedular() {
        userScheduler.fetchUsersAndSendSaMail();
    }
}
