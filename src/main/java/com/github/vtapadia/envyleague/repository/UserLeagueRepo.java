package com.github.vtapadia.envyleague.repository;

import com.github.vtapadia.envyleague.domain.UserLeague;
import com.github.vtapadia.envyleague.domain.key.UserLeagueKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User and there Leagues
 */
@Repository
public interface UserLeagueRepo extends JpaRepository<UserLeague, UserLeagueKey> {
}
