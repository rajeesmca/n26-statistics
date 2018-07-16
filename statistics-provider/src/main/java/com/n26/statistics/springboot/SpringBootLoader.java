package com.n26.statistics.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.n26.statistics"})
public class SpringBootLoader {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoader.class, args);
	}
}
