package com.interviewtrackingsystem.adminservice.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateDto {
	
	private Long candidateId;
	private String name;
	private String primarySkills;
	private String secondarySkills;
	private Integer experience;
	private String qualification;
	private String designation;
	private Integer noticePeriod;
	private String location;
	private String status;
	
	

}
