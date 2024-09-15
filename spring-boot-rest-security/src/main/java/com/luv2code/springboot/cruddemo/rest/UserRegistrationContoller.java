package com.luv2code.springboot.cruddemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.AppUser;
import com.luv2code.springboot.cruddemo.service.UserAuthorizationServiceImpl;

@RestController
@RequestMapping("/userRegistration")
public class UserRegistrationContoller {
	@Autowired
	private UserAuthorizationServiceImpl userAuthorizationServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<String> userRegistration(@RequestBody AppUser newUser) {
		userAuthorizationServiceImpl.save(newUser);
		return new ResponseEntity<String>("User Registration Successful..!!", HttpStatus.CREATED);

	}

}
