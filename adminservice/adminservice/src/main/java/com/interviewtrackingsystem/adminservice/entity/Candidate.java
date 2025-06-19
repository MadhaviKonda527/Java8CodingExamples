package com.interviewtrackingsystem.adminservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Candidates")
public class Candidate {
	
	@Id
	@Column(name = "candidateId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String primarySkills;
	
	@Column(nullable = false)
	private String secondarySkills;
	
	@Column(nullable = false)
	private Integer experience;
	
	@Column(nullable = false)
	private String qualification;
	
	
	private String designation;
	
	@Column(nullable = false)
	private Integer noticePeriod;
	
	private String location;
	
	
	private String status;
	

}
