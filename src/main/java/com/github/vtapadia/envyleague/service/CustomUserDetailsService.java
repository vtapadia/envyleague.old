package com.github.vtapadia.envyleague.service;

import com.github.vtapadia.envyleague.domain.AppUser;
import com.github.vtapadia.envyleague.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * User Details Service
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final AppUser appUser = appUserRepo.findOne(username);
        if (appUser != null) {

            return new User(appUser.getLogin(), appUser.getPassword(),
                    appUser.getRoles().stream().map(Enum::name).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        } else {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }
}
