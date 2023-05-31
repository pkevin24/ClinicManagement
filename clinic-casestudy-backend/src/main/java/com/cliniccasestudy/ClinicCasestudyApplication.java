package com.cliniccasestudy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cliniccasestudy.config.JwtRequestFilter;
import com.cliniccasestudy.service.JwtService;
import com.cliniccasestudy.util.JwtUtil;


@SpringBootApplication
public class ClinicCasestudyApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ClinicCasestudyApplication.class, args);
	}
	
//	@Bean
//	public JwtService getService() {
//		return new JwtService();
//	}
//	
//	@Bean
//	public JwtUtil getUtil() {
//		return new JwtUtil();
//	}
	
//	@Bean
//	public JwtRequestFilter getFilter() {
//		return new JwtRequestFilter();
//	}

}
