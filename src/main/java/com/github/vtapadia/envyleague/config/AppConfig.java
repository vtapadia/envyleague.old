package com.github.vtapadia.envyleague.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Application Config
 */
@Configuration
@Import(SwaggerConfig.class)
public class AppConfig {
}
