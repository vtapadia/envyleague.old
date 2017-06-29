package com.github.vtapadia.envyleague.repository;

import com.github.vtapadia.envyleague.domain.TournamentTeam;
import com.github.vtapadia.envyleague.domain.key.TournamentTeamKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Teams in a tournament.
 */
@Repository
public interface TournamentTeamRepo extends JpaRepository<TournamentTeam, TournamentTeamKey> {
}
