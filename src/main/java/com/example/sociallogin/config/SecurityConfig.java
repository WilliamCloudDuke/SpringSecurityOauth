package com.example.sociallogin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //create a new bean to customize security access for our endpoints
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //authorize security
        return http.authorizeHttpRequests(oauth -> {
                    oauth.requestMatchers("/").permitAll();
                    oauth.requestMatchers("/secured").authenticated();
                })
                .oauth2Login(withDefaults())
                .formLogin(withDefaults())//provide form login with default values
                .build();

    }


}
