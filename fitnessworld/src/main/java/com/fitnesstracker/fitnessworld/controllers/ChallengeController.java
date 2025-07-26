package com.fitnesstracker.fitnessworld.controllers;

import com.fitnesstracker.fitnessworld.entities.Challenge;
import com.fitnesstracker.fitnessworld.services.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeController {

@Autowired
private ChallengeService challengeService;

@GetMapping
public ResponseEntity<List<Challenge>> getAllChallenges(
@RequestParam(value = "reward", required = false) String reward,
@RequestParam(value = "sortBy", defaultValue = "startDate") String sortBy,
@RequestParam(value = "order", defaultValue = "asc") String order) {
List<Challenge> challenges = challengeService.getAllChallenges(reward, sortBy, order);
return ResponseEntity.ok(challenges);
}

@PostMapping("/participate/{challengeId}")
public ResponseEntity<String> participateInChallenge(
@PathVariable Long challengeId,
@RequestParam Long userId) {
challengeService.participateInChallenge(challengeId, userId);
return ResponseEntity.ok("Successfully joined the challenge!");
}
//test

@GetMapping("/startDate/{startDate}")
public ResponseEntity<List<Challenge>> getChallengesByStartDateAfter(
@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
List<Challenge> challenges = challengeService.getChallengesByStartDateAfter(startDate);
return ResponseEntity.ok(challenges);
}
}
