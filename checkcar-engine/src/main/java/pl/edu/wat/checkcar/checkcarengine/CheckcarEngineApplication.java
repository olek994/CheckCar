package pl.edu.wat.checkcar.checkcarengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(basePackages = {
		"pl.edu.wat.checkcar.checkcardomain",
		"pl.edu.wat.checkcar.checkcarengine.config",
		"pl.edu.wat.checkcar.checkcarengine.controller",
		"pl.edu.wat.checkcar.checkcarengine.mapper",
		"pl.edu.wat.checkcar.checkcarengine.provider",
		"pl.edu.wat.checkcar.checkcarengine.repository",
		"pl.edu.wat.checkcar.checkcarengine.service",})
@SpringBootApplication
@EnableAsync
public class CheckcarEngineApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CheckcarEngineApplication.class, args);
	}
}
