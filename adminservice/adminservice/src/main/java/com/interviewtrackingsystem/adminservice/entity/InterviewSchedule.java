package com.interviewtrackingsystem.adminservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class InterviewSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long interviewId;
	private Integer techRating;
	private Integer hrRating;
	private String finalStatus;
	
	@OneToOne
	@JoinColumn(name= "candidate_id", referencedColumnName = "candidateId", nullable = false, unique = true)
	private Candidate candidate;
	

}
