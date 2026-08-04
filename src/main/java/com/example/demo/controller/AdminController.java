package com.example.demo.controller;

import com.example.demo.cache.AppCache;
import com.example.demo.entites.User;
import com.example.demo.repository.ConfigJournalAppRepository;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private userService userService;

    @Autowired
    private AppCache appCache;

    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getAllUsers() {
   List<User> all=userService.getAll();
   if (all!=null){
       return new ResponseEntity<>(all, HttpStatus.OK);
     }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/create-admin-user")
    public void createUser(@RequestBody User user) {
        userService.saveAdmin(user);
  }

  @GetMapping("/clear-app-cache")
  public void clearAppCache(){
      appCache.intit();
  }

}
