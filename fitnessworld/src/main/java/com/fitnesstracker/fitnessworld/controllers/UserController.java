package com.fitnesstracker.fitnessworld.controllers;

import com.fitnesstracker.fitnessworld.entities.User;
import com.fitnesstracker.fitnessworld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

@Autowired
private UserService userService;

@PostMapping
public ResponseEntity<User> registerUser(@RequestBody User user) {
User savedUser = userService.registerUser(user);
return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
}

@GetMapping
public ResponseEntity<Page<User>> getUsersWithPagination(
@RequestParam(defaultValue = "0") int page,
@RequestParam(defaultValue = "10") int size) {

Page<User> users = userService.getUsers(PageRequest.of(page, size));
return new ResponseEntity<>(users, HttpStatus.OK);
}




@GetMapping("/email/{email}")
public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
Optional<User> user = userService.getUserByEmail(email);
return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
try {
User user = userService.updateUser(id, updatedUser);
return new ResponseEntity<>(user, HttpStatus.OK);
} catch (RuntimeException ex) {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
try {
userService.deleteUser(id);
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
} catch (RuntimeException ex) {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
}




