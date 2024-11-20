package com.employee.data.service.employementExchange;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = {"com.employee.data.service.employementExchange"})
public class EmployementExchangeApplication {
	/***
	 *  Using ModelMapper to create the object as Bean
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployementExchangeApplication.class, args);
	}

}
