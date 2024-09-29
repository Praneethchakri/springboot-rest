package com.jwt.authorization.security.jwtToken.SpringBoot.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDTO {
	private String email;
	private String password;
	private String fullName;

}
