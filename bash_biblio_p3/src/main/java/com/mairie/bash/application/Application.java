package com.mairie.bash.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {
	
	/**
	 * lance l'application spring
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
