import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MenagmentApplication {
	public static void main(String[] args) throws Exception{
		SpringApplication.run(MenagmentApplication.class, args);
	}
}