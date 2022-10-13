package com.airbook.app;

import com.airbook.app.model.User;
import com.airbook.app.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages = {"com.airbook.app"})
@EnableJpaRepositories(basePackages = {"com.airbook.app"})
public class MenagmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(MenagmentApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepo users, PasswordEncoder encoder) {
		return args -> {
			users.save(new User("user", encoder.encode("password"), "ROLE_USER"));
			users.save(new User("admin", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
		};
	}
}