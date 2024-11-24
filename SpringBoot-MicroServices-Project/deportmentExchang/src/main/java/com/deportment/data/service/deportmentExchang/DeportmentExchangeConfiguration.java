package com.deportment.data.service.deportmentExchang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DeportmentExchangeConfiguration {
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
