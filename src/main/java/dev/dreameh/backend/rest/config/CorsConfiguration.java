package dev.dreameh.backend.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

public class CorsConfiguration implements WebMvcConfigurer {

    // For local development
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        var origins = List.of("https://frontend-testing-thesis.herokuapp.com");
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                    .addMapping("/projects")
                    .allowedOrigins(origins.get(0));
            }
        };
    }
}
