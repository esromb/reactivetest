package com.example.reactive.reactivetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableMongoAuditing
@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactivetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivetestApplication.class, args);
	}
}
