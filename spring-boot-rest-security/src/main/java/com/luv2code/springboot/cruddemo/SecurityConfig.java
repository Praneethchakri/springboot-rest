package com.luv2code.springboot.cruddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//	@Value("${spring.security.user.name}")
//	private String userName;
//	@Value("${spring.security.user.password}")
//	private String password;
	@Autowired
	private UserDetailsService userService;

//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//		userDetailsManager.createUser(
//				User.withUsername(userName).password(passwordEncoder.encode(password)).roles("USER").build());
//		return userDetailsManager;
//	}


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
				.authorizeHttpRequests(authz -> authz.requestMatchers("/login", "/userRegistration/add").permitAll() 
						.anyRequest().authenticated() // Secure all endpoints
				).httpBasic(); // Enable Basic Auth
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

		return daoAuthenticationProvider;
	}

}
