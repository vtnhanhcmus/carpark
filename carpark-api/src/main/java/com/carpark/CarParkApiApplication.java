package com.carpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CarParkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarParkApiApplication.class, args);
	}

}
