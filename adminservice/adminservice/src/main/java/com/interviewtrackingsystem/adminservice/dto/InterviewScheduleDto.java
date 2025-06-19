package com.interviewtrackingsystem.adminservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InterviewScheduleDto {
	
	private Long interviewId;
	private Long candidateId;
	private Integer techRating;
	private Integer hrRating;
	private String finalStatus;
	

}
