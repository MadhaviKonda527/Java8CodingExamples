package com.interviewtrackingsystem.auth_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
com.interviewtrackingsystem.auth_Exception.AppException;
import com.interviewtrackingsystem.auth_Dto.SignUpRequest;
import com.interviewtrackingsystem.auth_Exception.AppException;
import com.interviewtrackingsystem.auth_Repository.RoleRepository;
import com.interviewtrackingsystem.auth_Repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void registerUser(SignUpRequest signUpRequest) {
		
		if(userRepository.existsByUsername(signUpRequest.getUsername())) {
			throw new AppException("User name ia already taken");
		}
		
	}
	

}
