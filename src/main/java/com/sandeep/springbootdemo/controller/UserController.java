package com.sandeep.springbootdemo.controller;

import com.sandeep.springbootdemo.annotation.Log;
import com.sandeep.springbootdemo.config.MailProps;
import com.sandeep.springbootdemo.dto.User;
import com.sandeep.springbootdemo.dto.UserRecord;
import com.sandeep.springbootdemo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@EnableTransactionManagement
public class UserController {
    @Autowired
    private MailProps mailProps;
    @Autowired
    private UserService userService;

    @PostMapping("/admin/addUser")
    public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/user")
    @Log
    public ResponseEntity<List<User>> getUser() {
//        UserRecord userRecord = new UserRecord(2,"jkk",23);
//        userRecord.age();
        List<User> users = userService.getUsers();
        return ResponseEntity.status(HttpStatus.FOUND).body(users);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> getAdmin() {
        List<User> admins = userService.getAdmins();
        return ResponseEntity.status(HttpStatus.FOUND).body(admins);
    }

}
