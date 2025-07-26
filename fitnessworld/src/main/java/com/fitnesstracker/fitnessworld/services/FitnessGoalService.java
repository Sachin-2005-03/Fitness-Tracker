package com.fitnesstracker.fitnessworld.services;

import com.fitnesstracker.fitnessworld.entities.FitnessGoal;
import com.fitnesstracker.fitnessworld.repositories.FitnessGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FitnessGoalService {

@Autowired
private FitnessGoalRepository fitnessGoalRepository;

public FitnessGoal createGoal(FitnessGoal fitnessGoal) {
return fitnessGoalRepository.save(fitnessGoal);
}

public List<FitnessGoal> getAllGoals(String sortBy, String order, int page, int size) {
Sort.Direction direction = order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
return fitnessGoalRepository.findAll(pageable).getContent();
}

public Page<FitnessGoal> getGoalsByUserId(Long userId, String goalType, Pageable pageable) {
if (goalType != null && !goalType.isEmpty()) {
return fitnessGoalRepository.findByUser_IdAndGoalType(userId, goalType, pageable);
} else {
return fitnessGoalRepository.findByUser_Id(userId, pageable);
}
}
public FitnessGoal updateGoal(Long id, FitnessGoal updatedGoal) {
Optional<FitnessGoal> existingGoal = fitnessGoalRepository.findById(id);
if (existingGoal.isPresent()) {
FitnessGoal goal = existingGoal.get();
goal.setGoalType(updatedGoal.getGoalType());
goal.setTargetValue(updatedGoal.getTargetValue());
goal.setStartDate(updatedGoal.getStartDate());
goal.setEndDate(updatedGoal.getEndDate());
return fitnessGoalRepository.save(goal);
}
return null;
}

public void deleteGoal(Long id) {
fitnessGoalRepository.deleteById(id);
}

public Object getGoalsByUserId(long l, String string, int i, int j) {
// TODO Auto-generated method stub
throw new UnsupportedOperationException("Unimplemented method 'getGoalsByUserId'");
}
}
