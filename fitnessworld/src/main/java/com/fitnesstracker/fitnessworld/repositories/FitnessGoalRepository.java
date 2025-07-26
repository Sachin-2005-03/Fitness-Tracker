package com.fitnesstracker.fitnessworld.repositories;

import com.fitnesstracker.fitnessworld.entities.FitnessGoal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessGoalRepository extends JpaRepository<FitnessGoal, Long> {
    Page<FitnessGoal> findByUser_Id(Long userId, Pageable pageable);
        Page<FitnessGoal> findByUser_IdAndGoalType(Long userId, String goalType, Pageable pageable);
            Page<FitnessGoal> findAll(Pageable pageable);
                }
                