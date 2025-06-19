package com.interviewtrackingsystem.adminservice.controller;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.interviewtrackingsystem.adminservice.dto.*;
import com.interviewtrackingsystem.adminservice.service.AdminService;
import com.interviewtrackingsystem.adminservice.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/admin")
//@ComponentScan(basePackages="com.interviewtrackingsystem.admin_Service")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/candidates")
	public ResponseEntity<CandidateDto> addCandidate(@RequestBody CandidateDto candidateDto){
		logger.info("Adding new candidate: {}", candidateDto.getName());
		return ResponseEntity.ok(adminService.addCandidate(candidateDto));
		
	}
	
	@GetMapping("/candidates/{id}")
	public ResponseEntity<CandidateDto> viewCandidate(@PathVariable Long id) throws ResourceNotFoundException{
		logger.info("Fetching candidate with ID: {}", id);
		return ResponseEntity.ok(adminService.getCandidateById(id));
		
	}
	
	@PostMapping("/candidates/share")
	public ResponseEntity<String> shareCandidateWithPanel(@RequestParam Long candidateId, @RequestParam Long interviewId, @RequestParam String panelType) throws ResourceNotFoundException {
		logger.info("Sharing candidate with the panel for interview", candidateId, panelType, interviewId);
		adminService.shareCandidateWithPanel(candidateId, interviewId, panelType);
		return ResponseEntity.ok("Candidate is shared with the panel");
	}
	
	
	  @PostMapping("/interviewSchedule") 
	  public ResponseEntity<String> interviewSchedule(@RequestBody InterviewScheduleDto interviewScheduleDto) throws ResourceNotFoundException{
		  logger.info("Scheduling interview for the candidate with Id : ",interviewScheduleDto.getCandidateId() );
		  return ResponseEntity.ok(adminService.interviewSchedule(interviewScheduleDto));
		  
	  }
	  
	
	

}
