package com.example.moodmix.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:3000")
                .allowedHeaders("Access-Control-Allow-Origin", "*", "Access-Control-Allow-Methods",
                        "POST, GET, OPTIONS, PUT, DELETE", "Access-Control-Allow-Headers",
                        "Origin, X-Requested-With, Content-Type, Accept")
                .allowedMethods("GET", "POST", "DELETE", "PATCH");
    }
}
