package com.in28.rest.basic.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class springconfigurationsecurity {

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
    	.csrf().disable()
        .authorizeHttpRequests((authz) -> authz
        		.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic();
    return http.build();
}
}
