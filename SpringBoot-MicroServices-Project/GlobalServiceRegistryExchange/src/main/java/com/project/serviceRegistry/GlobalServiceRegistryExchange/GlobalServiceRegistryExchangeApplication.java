package com.project.serviceRegistry.GlobalServiceRegistryExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // Adding this annotation to enable this micro Service as EurekaServer.
public class GlobalServiceRegistryExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalServiceRegistryExchangeApplication.class, args);
	}

}
