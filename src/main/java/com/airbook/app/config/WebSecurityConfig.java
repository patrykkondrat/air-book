package com.airbook.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.ignoringAntMatchers("/**"))
                .authorizeRequests(auth -> auth
                        .mvcMatchers("/user").permitAll()
                        .mvcMatchers("/admin").permitAll()
                        .mvcMatchers("/stuff").permitAll()
                        .mvcMatchers("/").permitAll()
                        .anyRequest().authenticated()
                )
                .userDetailsService(customUserDetailsServiceImpl)
                .headers(headers -> headers.frameOptions().sameOrigin())
                .httpBasic(withDefaults())

                .build();
    }

    //to test
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_ADMIN > ROLE_STAFF \n ROLE_STAFF > ROLE_USER";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
