package com.fitnesstracker.fitnessworld.controllers;

import com.fitnesstracker.fitnessworld.entities.FitnessGoal;
import com.fitnesstracker.fitnessworld.services.FitnessGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class FitnessGoalController {

@Autowired
private FitnessGoalService fitnessGoalService;

@PostMapping
public ResponseEntity<FitnessGoal> createGoal(@RequestBody FitnessGoal fitnessGoal) {
FitnessGoal createdGoal = fitnessGoalService.createGoal(fitnessGoal);
return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
}

@GetMapping
public ResponseEntity<List<FitnessGoal>> getAllGoals(
@RequestParam String sortBy,
@RequestParam String order,
@RequestParam int page,
@RequestParam int size) {
List<FitnessGoal> goals = fitnessGoalService.getAllGoals(sortBy, order, page, size);
return new ResponseEntity<>(goals, HttpStatus.OK);
}

@GetMapping("/user/{userId}")
public ResponseEntity<Page<FitnessGoal>> getGoalsByUserId(
@PathVariable Long userId,
@RequestParam(required = false) String goalType,
@PageableDefault Pageable pageable) {
Page<FitnessGoal> goals = fitnessGoalService.getGoalsByUserId(userId, goalType, pageable);
return new ResponseEntity<>(goals, HttpStatus.OK);
}

@PutMapping("/{id}")
public ResponseEntity<FitnessGoal> updateGoal(@PathVariable Long id, @RequestBody FitnessGoal updatedGoal) {
FitnessGoal goal = fitnessGoalService.updateGoal(id, updatedGoal);
if (goal != null) {
return new ResponseEntity<>(goal, HttpStatus.OK);
} else {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}   
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
fitnessGoalService.deleteGoal(id);
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
