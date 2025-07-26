package com.fitnesstracker.fitnessworld.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ChallengeParticipation {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String status;

@ManyToOne
@JoinColumn(name="user_id",nullable = false)
private User user;

@ManyToOne
@JoinColumn(name="challenge_id",nullable=false)
private Challenge challenge;

public ChallengeParticipation(Long id, String status, User user, Challenge challenge) {
this.id = id;
this.status = status;
this.user = user;
this.challenge = challenge;
}





}