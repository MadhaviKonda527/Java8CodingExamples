package com.interviewtrackingsystem.auth_Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SignUpRequest {
	
	@NotBlank
	@Size(min =4, max=40)
	private String name;
	
	@NotBlank
	@Size(min =3, max=15)
	private String username;
	
	@NotBlank
	@Size(max=40)
	@Email
	private String email;
	
	@NotBlank
	@Size(min =6, max=10)
	private String password;
	

}
