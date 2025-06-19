package com.interviewtrackingsystem.security;

import com.interviewtrackingsystem.auth_Repository.UserRepository;
import com.interviewtrackingsystem.auth_Entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	       User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not Found with username : "+username));
	       return UserPrincipal.create(user);
	       
	}
	
	@Transactional
	public UserDetails loadUserById(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found with id : "+ id));
		return UserPrincipal.create(user);
	}

}
