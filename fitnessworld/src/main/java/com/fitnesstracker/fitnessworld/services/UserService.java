package com.fitnesstracker.fitnessworld.services;
import com.fitnesstracker.fitnessworld.controllers.UserController;

import com.fitnesstracker.fitnessworld.entities.User;
import com.fitnesstracker.fitnessworld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

@Autowired
private UserRepository userRepository;

public User registerUser(User user) {
return userRepository.save(user); // Fix: return a single User, not Page<User>
}

public Page<User> getUsers(Pageable pageable) {
return userRepository.findAll(pageable);
}


public Optional<User> getUserByEmail(String email) {
return userRepository.findByEmail(email);
}

public Optional<User> getUserById(Long id) {
return userRepository.findById(id);
}

public User updateUser(Long id, User updatedUser) {
Optional<User> existingUser = userRepository.findById(id);
if (existingUser.isPresent()) {
User user = existingUser.get();
user.setUsername(updatedUser.getUsername());
user.setEmail(updatedUser.getEmail());
user.setFirstName(updatedUser.getFirstName());
user.setLastName(updatedUser.getLastName());
user.setPhoneNumber(updatedUser.getPhoneNumber());
user.setAddress(updatedUser.getAddress());

if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
user.setPassword(updatedUser.getPassword());
}

return userRepository.save(user);
} else {
throw new EntityNotFoundException("User not found with id: " + id);
}
}

public void deleteUser(Long id) {
if (userRepository.existsById(id)) {
userRepository.deleteById(id);
} else {
throw new EntityNotFoundException("User not found with id: " + id);
}
}

public Object getAllUsers() {

throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
}
}

