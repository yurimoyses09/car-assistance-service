package com.moyses.api_system_car;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ApiSystemCarApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiSystemCarApplication.class, args);
	}
}
