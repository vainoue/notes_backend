package com.example.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/newUser")
    public User newUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping("/{email}/{password}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String email, @PathVariable String password) {
        return new ResponseEntity<Optional<User>>(userService.singleUser(email, password), HttpStatus.OK);
    }
}
