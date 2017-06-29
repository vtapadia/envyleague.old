package com.github.vtapadia.envyleague.repository.football;

import com.github.vtapadia.envyleague.domain.football.FootballPrediction;
import com.github.vtapadia.envyleague.domain.football.FootballPredictionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Foorball Prediction repo
 */
@Repository
public interface FootballPredictionRepo extends JpaRepository<FootballPrediction, FootballPredictionKey> {
}
