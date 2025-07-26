package com.fitnesstracker.fitnessworld.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class FitnessGoal {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String goalType;
private Double targetValue;
private LocalDate startDate;
private LocalDate endDate;

@ManyToOne
@JoinColumn(name ="user_id")
private User user;
public FitnessGoal(Long id, User user, String goalType, Double targetValue, LocalDate startDate, LocalDate endDate) {
this.id = id;
this.user = user;
this.goalType = goalType;
this.targetValue = targetValue;
this.startDate = startDate;
this.endDate = endDate;
}


}