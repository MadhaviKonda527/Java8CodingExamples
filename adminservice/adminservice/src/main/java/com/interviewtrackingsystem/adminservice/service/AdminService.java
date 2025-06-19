package com.interviewtrackingsystem.adminservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interviewtrackingsystem.adminservice.exception.*;
import com.interviewtrackingsystem.adminservice.dto.*;
import com.interviewtrackingsystem.adminservice.entity.*;
import com.interviewtrackingsystem.adminservice.repository.CandidateRepository;
import com.interviewtrackingsystem.adminservice.repository.InterviewScheduleRepository;


//@ComponentScan(basePackages="com.interviewtrackingsystem.admin_Repository")
@Service
public class AdminService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private InterviewScheduleRepository interviewScheduleRepository;
	
	@Transactional
	public CandidateDto addCandidate(CandidateDto candidatedto) {
		Candidate candidate = Candidate.builder()
                .name(candidatedto.getName())
                .primarySkills(candidatedto.getPrimarySkills())
                .secondarySkills(candidatedto.getSecondarySkills())
                .experience(candidatedto.getExperience())
                .qualification(candidatedto.getQualification())
                .designation(candidatedto.getDesignation())
                .noticePeriod(candidatedto.getNoticePeriod())
                .location(candidatedto.getLocation())
                .build();
		candidateRepository.save(candidate);
        logger.info("new candidate created with the ID :"+candidate.getId());
        return mapToCandidateDto(candidate);
        
	}

	private CandidateDto mapToCandidateDto(Candidate candidate) {
		CandidateDto candidateDto = CandidateDto.builder()
				.candidateId(candidate.getId())
				.name(candidate.getName())
                .primarySkills(candidate.getPrimarySkills())
                .secondarySkills(candidate.getSecondarySkills())
                .experience(candidate.getExperience())
                .qualification(candidate.getQualification())
                .designation(candidate.getDesignation())
                .noticePeriod(candidate.getNoticePeriod())
                .location(candidate.getLocation())
                .status(candidate.getStatus())
                .build();
		
		return candidateDto;
	}
	
	
	public CandidateDto getCandidateById(Long candidateId) throws ResourceNotFoundException { 
		  
		Optional<Candidate> candidateOp =  candidateRepository.findById(candidateId);/*.map(candidatemap -> CandidateDto.builder()
				  .candidateId(candidatemap.getId())
				  .name(candidatemap.getName())
	              .primarySkills(candidatemap.getPrimarySkills())
	              .secondarySkills(candidatemap.getSecondarySkills())
	              .experience(candidatemap.getExperience())
	              .qualification(candidatemap.getQualification())
	              .designation(candidatemap.getDesignation())
	              .noticePeriod(candidatemap.getNoticePeriod())
	              .location(candidatemap.getLocation()) 
	              .status(candidatemap.getStatus())
	              .build());*/
		candidateOp.orElseThrow(() -> new ResourceNotFoundException("Candidate not found"));
		Candidate candidate = candidateOp.get();
		return mapToCandidateDto(candidate);
		
	}

	@Transactional
	public void shareCandidateWithPanel(Long candidateId, Long interviewId, String panelType) throws ResourceNotFoundException {
		Optional<Candidate> candidateOp = candidateRepository.findById(candidateId);/*.orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id: "));*/
		candidateOp.orElseThrow(() -> new ResourceNotFoundException("Candidate not found"));
		Candidate candidate = candidateOp.get();
		if("HR".equalsIgnoreCase(panelType)) {
			candidate.setStatus("Shared with HR");
		} else if ("TECH".equalsIgnoreCase(panelType)) {
			candidate.setStatus("Shared with Tech");
		}
		candidateRepository.save(candidate);
		
	}
	
	@Transactional
	public String interviewSchedule(InterviewScheduleDto interviewScheduledto) throws ResourceNotFoundException {
		Candidate candidate = candidateRepository.findById(interviewScheduledto.getCandidateId()).orElseThrow(() -> new ResourceNotFoundException("Candiate not found"));
		Boolean interviewScheduled = interviewScheduleRepository.existsByInterviewId(interviewScheduledto.getInterviewId());
		if(interviewScheduled) {
			logger.debug("Interview Already scheduled with the given ID" );
			return "Interview Already scheduled with the given ID";
		}else {
		InterviewSchedule interviewSchedule = InterviewSchedule.builder()
		.interviewId(interviewScheduledto.getInterviewId())
		.candidate(candidate)
		.build();
		interviewScheduleRepository.save(interviewSchedule);
		return "Interview scheduled with the given ID";
		}
	}
	
	
	/*private InterviewScheduleDto mapToInterviewScheduleDto(InterviewSchedule interviewSchedule) {
		InterviewScheduleDto interviewScheduleDto = InterviewScheduleDto.builder()
				.interviewId(interviewSchedule.getInterviewId())
				.candiateId(null)
                .build();
		
		return interviewScheduleDto;
	}
	
	private InterviewScheduleDto mapToInterviewSchedule(InterviewScheduleDto interviewScheduleDto) {
		InterviewScheduleDto interviewScheduleDto = InterviewSchedule.builder()
				.interviewId(interviewSchedule.getInterviewId())
				.candiateId(null)
                .build();
		
		return interviewScheduleDto;
	}*/
	 

}
