package com.interviewtrackingsystem.techpanelservice.clients;

import com.interviewtrackingsystem.techpanelservice.dto.CandidateDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "adminservice")
public interface CandidateClient {
	
	
	@GetMapping("/api/admin/candidates/{id}")
	CandidateDto viewCandidate(@PathVariable Long id);

}
