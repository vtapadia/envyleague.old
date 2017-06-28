package com.github.vtapadia.envyleague.repository;

import com.github.vtapadia.envyleague.domain.PersistentToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Persistent Token repository
 */
@Repository
public interface PersistentTokenRepo extends JpaRepository<PersistentToken, String> {
    Long deleteByAppUser_Login(String username);
}
