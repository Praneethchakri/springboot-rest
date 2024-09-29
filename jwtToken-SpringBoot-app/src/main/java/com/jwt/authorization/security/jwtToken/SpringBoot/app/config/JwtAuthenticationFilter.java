package com.jwt.authorization.security.jwtToken.SpringBoot.app.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.jwt.authorization.security.jwtToken.SpringBoot.app.service.JwtService;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	private final JwtService jwtService;
	private final UserDetailsService userDetailsService;
	private final HandlerExceptionResolver handlerExceptionResolver;
	
	public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService,
			HandlerExceptionResolver handlerExceptionResolver) {
		this.jwtService = jwtService;
		this.userDetailsService = userDetailsService;
		this.handlerExceptionResolver = handlerExceptionResolver;
	}

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @	NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain) throws ServletException, IOException {
		
		log.debug("Processing JWT for request: ==> " + request.getRequestURI());
		

		final String authHeader = request.getHeader("Authorization");
		log.debug("Processing JWT for request Header authHeader ==> " + authHeader);
		final String jwtToken ;
		final String userEmail ;

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			log.debug("Here in if Clause");
			filterChain.doFilter(request, response);
			return;
		}
		try {
			 jwtToken = authHeader.substring(7);
			 userEmail = jwtService.extractUserName(jwtToken);
			 	log.debug("JWT Token:  ==> " + jwtToken);
				log.debug("Extracted User Email:  ==>" + userEmail);
				log.debug("Authentication:  ==>" + SecurityContextHolder.getContext().getAuthentication());

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			System.out.println("Authentication ====> "+authentication);
			
			if (userEmail != null && authentication == null) {
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

				if (jwtService.isTokenValid(jwtToken, userDetails)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					  log.debug("Successfully authenticated: " + userEmail);
				}

			}else {
	            log.debug("User is already authenticated or token is invalid");
	        }
			log.debug("Processing JWT for request: ==> " + request.getRequestURI());
			log.debug("JWT Token:  ==> " + jwtToken);
			log.debug("Extracted User Email:  ==>" + userEmail);
			log.debug("Authentication:  ==>" + SecurityContextHolder.getContext().getAuthentication());

			filterChain.doFilter(request, response);

		} catch (Exception e) {
			log.debug("Here in catch Clause"+e);
			handlerExceptionResolver.resolveException(request, response, null, e);
		}

	}

}
