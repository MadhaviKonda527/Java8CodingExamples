package com.interviewtrackingsystem.adminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(basePackages="com.interviewtrackingsystem.admin_Service")
//@ComponentScan(basePackages="com.interviewtrackingsystem.admin_Controller")
//@EntityScan(basePackages="com.interviewtrackingsystem.admin_Entity")
//@EnableJpaRepositories(basePackages="com.interviewtrackingsystem.admin_Repository")
public class AdminserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminserviceApplication.class, args);
	}

}
