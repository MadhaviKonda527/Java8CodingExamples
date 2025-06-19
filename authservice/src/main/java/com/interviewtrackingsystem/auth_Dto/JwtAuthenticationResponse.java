package com.interviewtrackingsystem.auth_Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {
	
	private String accessToken;
	private String tokenType = "Bearer";
	
	public JwtAuthenticationResponse(String token){
		this.accessToken = token;
	}
	

}
