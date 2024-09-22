package com.secuirty.SpringBoot.security.topics.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

	@GetMapping("/balanceDetils")
	public String getBalanceDetils() {
		return "Balance Details API Called..!";
	}

}
