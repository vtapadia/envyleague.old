package com.github.vtapadia.envyleague.repository.football;

import com.github.vtapadia.envyleague.domain.football.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Football Match Repo
 */
@Repository
public interface FootballMatchRepo extends JpaRepository<FootballMatch, Integer> {
}
