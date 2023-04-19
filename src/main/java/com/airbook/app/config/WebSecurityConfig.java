package com.airbook.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.airbook.app.service.CustomUserDetailsServiceImpl;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    private final CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

    public WebSecurityConfig(CustomUserDetailsServiceImpl customUserDetailsServiceImpl) {
        this.customUserDetailsServiceImpl = customUserDetailsServiceImpl;
    }

    @Bean
    @Order(1)
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").permitAll()
                        .requestMatchers("/stuff/**").permitAll()
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers("/css/**", "/").permitAll()
                        .requestMatchers("/css/**", "/register").permitAll()
                        .requestMatchers("/css/**", "/login").permitAll()
                        .anyRequest().permitAll()
                )
                .userDetailsService(customUserDetailsServiceImpl)

                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                .defaultSuccessUrl("/index", true)
                .failureUrl("/login-error")
                .and()
                .logout()
                .logoutSuccessUrl("/index")

                .and()
                .headers(headers -> headers.frameOptions().sameOrigin())
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
