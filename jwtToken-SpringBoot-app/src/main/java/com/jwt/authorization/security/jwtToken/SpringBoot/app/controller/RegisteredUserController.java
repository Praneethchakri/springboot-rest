package com.jwt.authorization.security.jwtToken.SpringBoot.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.authorization.security.jwtToken.SpringBoot.app.entity.UserRegisterEntity;
import com.jwt.authorization.security.jwtToken.SpringBoot.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class RegisteredUserController{
	
	private final UserService userService;

    public RegisteredUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication == null || !authentication.isAuthenticated()) {
            log.error("Authentication is null or not authenticated");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        Object principal = authentication.getPrincipal();
        log.info("Principal: " + principal);
        
        if (principal instanceof UserRegisterEntity) {
            UserRegisterEntity currentUser = (UserRegisterEntity) principal;
            log.info("Current User: " + currentUser);
            return ResponseEntity.ok(currentUser);
        } else {
            log.error("Principal is not of type UserRegisterEntity");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping
    public ResponseEntity<List<UserRegisterEntity>> allUsers() {
        List <UserRegisterEntity> users = userService.getAllRegisteredUsers();
        System.out.println("allUsers in RegisteredUserController "+users);
        log.info("allUsers in RegisteredUserController "+users);
        return ResponseEntity.ok(users);
    }
}