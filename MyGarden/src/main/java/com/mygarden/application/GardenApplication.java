package com.mygarden.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.mygarden")
public class GardenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GardenApplication.class, args);
	}

}
