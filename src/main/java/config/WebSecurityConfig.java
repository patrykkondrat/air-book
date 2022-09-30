//package ForLater.config;
//
//import ForLater.User;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        User user = new User("user", "password", "USER");
//        User admin = new User("admin", "password", "ADMIN");
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
//        return http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> {
//                    auth.antMatchers("/").permitAll();
//                    auth.antMatchers("/getall").hasRole("ADMIN")
//                            .anyRequest().authenticated();
//                    auth.antMatchers("/book/**").hasAnyRole("USER", "ADMIN")
//                            .anyRequest().authenticated();
//                })
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .logout((logout) -> logout.permitAll())
//                .build();
//    }
//}
