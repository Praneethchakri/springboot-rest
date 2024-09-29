package com.jwt.authorization.security.jwtToken.SpringBoot.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.authorization.security.jwtToken.SpringBoot.app.dto.LoginResponse;
import com.jwt.authorization.security.jwtToken.SpringBoot.app.dto.LoginUserDTO;
import com.jwt.authorization.security.jwtToken.SpringBoot.app.dto.RegisterUserDTO;
import com.jwt.authorization.security.jwtToken.SpringBoot.app.entity.UserRegisterEntity;
import com.jwt.authorization.security.jwtToken.SpringBoot.app.service.AuthenticationService;
import com.jwt.authorization.security.jwtToken.SpringBoot.app.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	private final JwtService jwtService;

	private final AuthenticationService authenticationService;

	public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
		this.jwtService = jwtService;
		this.authenticationService = authenticationService;
	}

	@PostMapping("/signup")
	public ResponseEntity<UserRegisterEntity> register(@RequestBody RegisterUserDTO registerUserDTO) {
		UserRegisterEntity newEntity = authenticationService.registerNewUser(registerUserDTO);
		return ResponseEntity.ok(newEntity);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDTO) {
		UserRegisterEntity existingUserLogin = authenticationService.authenticateExistingUser(loginUserDTO);

		String jwtToken = jwtService.generateToken(existingUserLogin);
		LoginResponse response = new LoginResponse().setToken(jwtToken)
				.setTokenExpirationInMilliSecond(jwtService.getExpirationTime());

		return ResponseEntity.ok(response);
	}

}
