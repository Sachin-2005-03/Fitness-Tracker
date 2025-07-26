package com.fitnesstracker.fitnessworld.services;

import com.fitnesstracker.fitnessworld.entities.ActivityLog;
import com.fitnesstracker.fitnessworld.repositories.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

@Autowired
private ActivityLogRepository activityLogRepository;

public ActivityLog createActivityLog(ActivityLog activityLog) {

if (activityLog.getActivityType() == null || activityLog.getActivityType().isEmpty() || activityLog.getValue() == null || activityLog.getLogDate() == null || activityLog.getUser() == null) {
throw new IllegalArgumentException("Required fields are missing");
}
return activityLogRepository.save(activityLog);
}

public List<ActivityLog> getAllActivityLogs() {
return activityLogRepository.findAll();
}
}

