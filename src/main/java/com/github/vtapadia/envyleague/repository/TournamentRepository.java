package com.github.vtapadia.envyleague.repository;

import com.github.vtapadia.envyleague.domain.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Tournament Repository
 */
@Repository
public interface TournamentRepository extends JpaRepository<Tournament, String> {

}
