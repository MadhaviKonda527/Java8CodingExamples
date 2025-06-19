package com.interviewtrackingsystem.auth_Entity;

import org.hibernate.annotations.NaturalId;

import com.interviewtrackingsystem.auth_Entity.enums.RoleName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length = 60)
	private RoleName name;
	
	public Role() {}
	
	public Role(RoleName name) {
		this.name = name;
	}
	
	

}
