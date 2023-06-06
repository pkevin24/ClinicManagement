package com.chatgpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.chatgpt.model.User;
import com.chatgpt.util.jwtToken;
import com.chatgpt.util.jwtutil;

@SpringBootApplication
public class ClinicManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicManagementApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public jwtToken getToken() {
		return new jwtToken();
	}

	@Bean
	public User getUser() {
		return new User();
	}

	@Bean
	public jwtutil getUtil() {
		return new jwtutil();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("*").allowedOrigins("*");
			}
		};
	}

}
