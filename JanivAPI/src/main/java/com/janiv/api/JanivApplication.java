package com.janiv.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.*"})
public class JanivApplication {

	public static void main(String[] args) {
		SpringApplication.run(JanivApplication.class, args);
	}

}
