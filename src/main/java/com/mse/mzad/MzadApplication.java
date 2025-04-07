package com.mse.mzad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MzadApplication {

	public static void main(String[] args) {
		SpringApplication.run(MzadApplication.class, args);
	}

}
