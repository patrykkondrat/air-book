package app;

import model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import repo.UserRepo;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class MenagmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(MenagmentApplication.class, args);
		System.out.println("run");
	}

}