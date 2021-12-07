package com.example.eurekaserverapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverapiApplication.class, args);
	}

}
