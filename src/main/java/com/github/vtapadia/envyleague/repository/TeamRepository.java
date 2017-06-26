package com.github.vtapadia.envyleague.repository;

import com.github.vtapadia.envyleague.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Team Repository interface
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, String> {

}
