package com.demo.user.service.controller;

import com.demo.user.service.entity.User;
import com.demo.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       User u = userService.saveUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User u = userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> users =  userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
