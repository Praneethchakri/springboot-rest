package com.secuirty.SpringBoot.security.topics.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

	@GetMapping("/loansDetils")
	public String getLoansDetils() {
		return "LoansDetils  API Called..!";
	}

}
