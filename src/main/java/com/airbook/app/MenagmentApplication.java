package com.airbook.app;

import com.airbook.app.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.airbook.app.repo.UserRepo;

@SpringBootApplication
public class MenagmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(MenagmentApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepo users, PasswordEncoder encoder) {
		return args -> {
			users.save(new User("user", encoder.encode("password"), "USER"));
			users.save(new User("admin", encoder.encode("password"), "ADMIN"));
		};
	}
}