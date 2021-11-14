package knc.assignment.kncshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {SecurityException.class})
public class KncshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(KncshopApplication.class, args);
	}

}
