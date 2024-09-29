package com.jwt.authorization.security.jwtToken.SpringBoot.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jwt.authorization.security.jwtToken.SpringBoot.app.entity.UserRegisterEntity;
import com.jwt.authorization.security.jwtToken.SpringBoot.app.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserRegisterEntity> getAllRegisteredUsers() {
		List<UserRegisterEntity> registeredUserList = new ArrayList<>();
		userRepository.findAll().forEach(registeredUserList::add);
		return registeredUserList;
	}

}
