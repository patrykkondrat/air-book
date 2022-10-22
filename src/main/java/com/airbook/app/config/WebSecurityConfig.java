package com.airbook.app.config;

import com.airbook.app.service.CustomUserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> auth
                        .mvcMatchers("/admin/**").permitAll()
                        .mvcMatchers("/stuff/**").permitAll()
                        .mvcMatchers("/user/**").permitAll()
//                        .mvcMatchers("/css/**", "/").permitAll()
//                        .mvcMatchers("/css/**", "/registration").permitAll()
//                        .mvcMatchers("/css/**", "/login").permitAll()
//                        .mvcMatchers("/css/**", "/employee_reg").permitAll()
                        .antMatchers("/flight/**").permitAll()
                        .anyRequest().fullyAuthenticated()
                )
                .userDetailsService(customUserDetailsServiceImpl)

                .formLogin()
//                    .loginPage("/login")
//                    .usernameParameter("username").permitAll()
//                .defaultSuccessUrl("/index", true)
//                .failureUrl("/login-error")
                .and()
                .logout().permitAll()
//                .logoutSuccessUrl("/index")

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
