package com.example.practice;

import com.example.practice.dao.UserRepository;
import com.example.practice.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class PracticeApplication {

	@Bean
	public WebClient.Builder getBuilder()
	{
		return WebClient.builder();
	}

	public static void main(String[] args)
	{
		SpringApplication.run(PracticeApplication.class, args);

	}

}
