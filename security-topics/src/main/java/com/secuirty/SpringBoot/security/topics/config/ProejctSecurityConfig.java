package com.secuirty.SpringBoot.security.topics.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProejctSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				(request) -> request.requestMatchers("/accountDetils", "/balanceDetils", "/loansDetils").authenticated()
						.requestMatchers("/contactDetils", "/notifications","/error").permitAll());
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();

	}
}
