package com.deportment.data.service.deportmentExchang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DeportmentExchangApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeportmentExchangApplication.class, args);
	}

}
