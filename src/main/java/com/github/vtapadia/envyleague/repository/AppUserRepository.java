package com.github.vtapadia.envyleague.repository;

import com.github.vtapadia.envyleague.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AppUser Repository
 */
public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
