package com.secuirty.SpringBoot.security.topics.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

	@GetMapping("/notifications")
	public String getNotificationDetails() {
		return "Notification  API Called..!";
	}

}
