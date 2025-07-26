package com.fitnesstracker.fitnessworld.controllers;

import com.fitnesstracker.fitnessworld.entities.ActivityLog;
import com.fitnesstracker.fitnessworld.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

@Autowired
private ActivityService activityService;

@PostMapping
public ResponseEntity<ActivityLog> createActivityLog(@RequestBody ActivityLog activityLog) {
ActivityLog createdLog = activityService.createActivityLog(activityLog);
return ResponseEntity.status(201).body(createdLog);
}

@GetMapping
public ResponseEntity<List<ActivityLog>> getAllActivityLogs() {
List<ActivityLog> activityLogs = activityService.getAllActivityLogs();
return ResponseEntity.ok(activityLogs);
}
}