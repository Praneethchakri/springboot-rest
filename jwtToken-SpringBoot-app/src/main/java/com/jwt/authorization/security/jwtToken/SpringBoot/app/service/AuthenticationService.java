package com.jwt.authorization.security.jwtToken.SpringBoot.app.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.authorization.security.jwtToken.SpringBoot.app.dto.LoginUserDTO;
import com.jwt.authorization.security.jwtToken.SpringBoot.app.dto.RegisterUserDTO;
import com.jwt.authorization.security.jwtToken.SpringBoot.app.entity.UserRegisterEntity;
import com.jwt.authorization.security.jwtToken.SpringBoot.app.repository.UserRepository;

@Service
public class AuthenticationService {

	private final UserRepository userRepo;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	public AuthenticationService(UserRepository userRepo, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
	}

	public UserRegisterEntity registerNewUser(RegisterUserDTO registerUserDTO) {
		UserRegisterEntity user = new UserRegisterEntity();
		user.setFullName(registerUserDTO.getFullName());
		user.setEmail(registerUserDTO.getEmail());
		user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));

		return userRepo.save(user);
	}

	public UserRegisterEntity authenticateExistingUser(LoginUserDTO loginUser) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail()	, loginUser.getPassword()));
		return userRepo.findByEmail(loginUser.getEmail()).orElseThrow();
	}

}
