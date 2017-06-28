package com.github.vtapadia.envyleague.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;

/**
 * Security Configuration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${app.remember.me.key:springSecurityRememberMeKey}")
    private String key;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public RememberMeServices rememberMeServices(UserDetailsService userDetailsService) {
        return new PersistentTokenBasedRememberMeServices(key, userDetailsService, persistentTokenRepository);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    @Autowired
    public RememberMeAuthenticationFilter authenticationFilter(AuthenticationManager authenticationManager, RememberMeServices rememberMeServices) {
        return new RememberMeAuthenticationFilter(authenticationManager, rememberMeServices);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
