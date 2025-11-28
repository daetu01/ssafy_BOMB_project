package com.ssafy.bomb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BombApplication {

	public static void main(String[] args) {

		SpringApplication.run(BombApplication.class, args);
	}

}
