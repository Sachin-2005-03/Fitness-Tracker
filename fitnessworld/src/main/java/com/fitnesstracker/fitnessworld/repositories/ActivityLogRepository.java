package com.fitnesstracker.fitnessworld.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fitnesstracker.fitnessworld.entities.ActivityLog;
import java.util.List;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
@Query("SELECT a FROM ActivityLog a WHERE a.user.id = :userId")
List<ActivityLog> findByUserId(@Param("userId") Long userId);
}
