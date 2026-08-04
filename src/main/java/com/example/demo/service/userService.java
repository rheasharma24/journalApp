package com.example.demo.service;

import com.example.demo.controller.journalEntryController;
import com.example.demo.entites.User;
import com.example.demo.repository.userRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
@Service //it is for readability
public class userService {
    @Autowired
    private  userRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    private static  final Logger logger = LoggerFactory.getLogger(userService.class);


    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public  boolean saveNewEntry(User user){
           try {
               user.setPassword(passwordEncoder.encode(user.getPassword()));
               user.setRoles(Arrays.asList("USER"));
               userRepository.save(user);
               return true;
           } catch (Exception e) {
               log.error("hahahahaha");
               log.warn("hahahahaha");
               log.info("hahahahaha");
               log.debug("hahahahaha");
               log.trace("hahahahaha");
               return false;
           }
    }
    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public  User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }


}

