package com.secuirty.SpringBoot.security.topics.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping("/accountDetils")
	public String getAccountDetails() {
		return "Account Details API Called..!";
	}

}
