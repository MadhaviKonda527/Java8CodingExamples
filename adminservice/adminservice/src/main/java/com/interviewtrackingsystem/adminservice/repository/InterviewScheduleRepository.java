package com.interviewtrackingsystem.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interviewtrackingsystem.adminservice.entity.InterviewSchedule;

public interface InterviewScheduleRepository extends JpaRepository<InterviewSchedule, Long>{
   
	Boolean existsByInterviewId(Long interviewId);
}
