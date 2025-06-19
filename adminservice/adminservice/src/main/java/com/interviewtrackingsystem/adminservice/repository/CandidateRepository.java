package com.interviewtrackingsystem.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interviewtrackingsystem.adminservice.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>{

}
