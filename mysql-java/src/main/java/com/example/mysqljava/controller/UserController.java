package com.example.mysqljava.controller;

import com.example.mysqljava.model.User;
import com.example.mysqljava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/user/{email}")
    public ResponseEntity<?> updateUser(@PathVariable String email, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(email, user), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        if (id != null)
            return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
        if (firstName != null)
            return new ResponseEntity<>(userService.getByFirstName(firstName), HttpStatus.OK);
        if (lastName != null)
            return new ResponseEntity<>(userService.getByLastName(lastName), HttpStatus.OK);
        if (email != null)
            return new ResponseEntity<>(userService.getByEmail(email), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
