package com.interviewtrackingsystem.auth_Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
	
	private Boolean success;
	private String message;

}
