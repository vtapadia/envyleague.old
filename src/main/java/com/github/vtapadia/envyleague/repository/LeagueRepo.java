package com.github.vtapadia.envyleague.repository;

import com.github.vtapadia.envyleague.domain.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * League Repository
 */
@Repository
public interface LeagueRepo extends JpaRepository<League, String> {
}
