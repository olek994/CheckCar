package pl.edu.wat.checkcar.checkcarsso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class CheckcarssoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CheckcarssoApplication.class, args);
	}
}
