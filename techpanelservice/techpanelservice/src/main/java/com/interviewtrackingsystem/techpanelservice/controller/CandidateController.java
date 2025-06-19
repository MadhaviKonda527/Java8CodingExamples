package com.interviewtrackingsystem.techpanelservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewtrackingsystem.techpanelservice.clients.CandidateClient;
import com.interviewtrackingsystem.techpanelservice.dto.CandidateDto;
//import com.interviewtrackingsystem.techpanelservice.service.CandidateService;

@RestController
@RequestMapping("/api/techpanel")
public class CandidateController {
	
	/*
	 * @Autowired private CandidateService candidateService;
	 */
	@Autowired 
	private CandidateClient candidateclient;
	
	@GetMapping("/candidate/{id}")
	CandidateDto viewCandidate(@PathVariable Long id) {
		//return candidateService.viewCandidate(id);
		return candidateclient.viewCandidate(id);
	}
	
	

}
