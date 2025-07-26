package com.fitnesstracker.fitnessworld.entities;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String challengeName;
private LocalDate startDate;
private LocalDate endDate;
private String reward;

@OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true)
private List<ChallengeParticipation> participants;
public Challenge(Long id, String challengeName, LocalDate startDate, LocalDate endDate, String reward) {
this.id = id;
this.challengeName = challengeName;
this.startDate = startDate;
this.endDate = endDate;
this.reward = reward;
    }
    }
    
