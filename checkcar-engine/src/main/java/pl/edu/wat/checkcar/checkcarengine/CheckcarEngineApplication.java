package pl.edu.wat.checkcar.checkcarengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("pl.edu.wat.checkcar.checkcarengine")
public class CheckcarEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckcarEngineApplication.class, args);
	}
}
