package com.api.ramengo.config;

import com.api.ramengo.service.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private ApiKeyService apiKeyService;

    @Bean
    public ApiKeyService apiKeyService() {
        return new ApiKeyService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        ApiKeyFilter apiKeyFilter = new ApiKeyFilter(apiKeyService);

        return http
                .addFilterBefore(apiKeyFilter, AbstractPreAuthenticatedProcessingFilter.class)
                .authorizeHttpRequests(authorizeHttpRequests ->
                        authorizeHttpRequests
                                .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}
