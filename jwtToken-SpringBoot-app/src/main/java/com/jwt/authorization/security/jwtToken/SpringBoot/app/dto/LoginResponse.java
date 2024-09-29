package com.jwt.authorization.security.jwtToken.SpringBoot.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	private String token;
	private long tokenExpirationInMilliSecond;

}
