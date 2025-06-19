package com.interviewtrackingsystem.auth_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewtrackingsystem.auth_Dto.ApiResponse;
import com.interviewtrackingsystem.auth_Dto.JwtAuthenticationResponse;
import com.interviewtrackingsystem.auth_Dto.LoginRequest;
import com.interviewtrackingsystem.auth_Dto.SignUpRequest;
import com.interviewtrackingsystem.auth_Service.AuthService;
import com.interviewtrackingsystem.security.JwtTokenProvider;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	 AuthenticationManager authenticationManager;
	
	@Autowired
	 AuthService authService;
	
	@Autowired
	 JwtTokenProvider tokenProvider;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest){
		
		authService.registerUser(signUpRequest);
		return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
	}
	
	
	
	
	

}
