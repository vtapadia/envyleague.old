package com.github.vtapadia.envyleague.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.github.vtapadia.envyleague.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
