package com.esprit.microservices.eventsplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EventsplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsplannerApplication.class, args);
	}

}
