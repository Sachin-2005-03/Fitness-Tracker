package com.fitnesstracker.fitnessworld.entities;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activity_type", nullable = false) // Added nullable = false
    private String activityType;

    @Column(nullable = false) // Added nullable = false
    private Double value;

    @Column(name = "log_date", nullable = false) // Added nullable = false
    private LocalDate logDate;

    @ManyToOne(fetch = FetchType.LAZY) // Added fetch = FetchType.LAZY
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ActivityLog(Long id, User user, String activityType, Double value, LocalDate logDate) {
    this.id = id;
    this.user = user;
    this.activityType = activityType;
    this.value = value;
    this.logDate = logDate;
    }
    }
