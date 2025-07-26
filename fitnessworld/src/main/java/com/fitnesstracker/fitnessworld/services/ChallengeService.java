
    package com.fitnesstracker.fitnessworld.services;

    import com.fitnesstracker.fitnessworld.entities.Challenge;
    import com.fitnesstracker.fitnessworld.entities.ChallengeParticipation;
    import com.fitnesstracker.fitnessworld.repositories.ChallengeParticipationRepository;
    import com.fitnesstracker.fitnessworld.repositories.ChallengeRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Sort;
    import org.springframework.stereotype.Service;

    import java.time.LocalDate;
    import java.sql.Date;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private ChallengeParticipationRepository challengeParticipationRepository;

    public List<Challenge> getAllChallenges(String reward, String sortBy, String order) {

    Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
    Sort sort = Sort.by(direction, sortBy);

    if (reward != null && !reward.isEmpty()) {
    return challengeRepository.findByReward(reward, sort);
    } else {
    return challengeRepository.findAll(sort);
    }
    }


    public void participateInChallenge(Long challengeId, Long userId) {
    Optional<Challenge> optionalChallenge = challengeRepository.findById(challengeId);
    if (!optionalChallenge.isPresent()) {
    throw new IllegalArgumentException("Challenge not found");
    }
    Challenge challenge = optionalChallenge.get();

    boolean alreadyParticipating = challengeParticipationRepository.existsByChallengeIdAndUserId(challengeId, userId);
    if (alreadyParticipating) {
    throw new IllegalArgumentException("User is already participating in this challenge");
    }

    ChallengeParticipation participation = new ChallengeParticipation();
    participation.setChallenge(challenge);
    participation.setId(userId); 
    challengeParticipationRepository.save(participation);

    }

    public List<Challenge> getChallengesByStartDateAfter(LocalDate startDate) {
    return challengeRepository.findByStartDate(Date.valueOf(startDate)); // Convert LocalDate to Date
    }
    }

