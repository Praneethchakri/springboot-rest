package com.di.Inversionofcontrol.injectionTypes_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.di.Inversionofcontrol.injectionTypes_spring.repo.InvestorRepository;
import com.di.Inversionofcontrol.injectionTypes_spring.service.InvestorService;
import com.di.Inversionofcontrol.injectionTypes_spring.service.InvestorServiceImpl;

@Configuration                
@ComponentScan(basePackages = "com.di.Inversionofcontrol.injectionTypes_spring")
public class InjectionTypesSpringConfiguration {
	
	@Autowired
	private InvestorRepository investorRepository;
	
	@Bean
	public InvestorService investorServiceBean() {
		return new InvestorServiceImpl(investorRepository);
	}
}
