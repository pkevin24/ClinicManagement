package com.cliniccasestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliniccasestudy.entity.JwtRequest;
import com.cliniccasestudy.entity.JwtResponse;
import com.cliniccasestudy.service.JwtService;

@RestController
public class JwtController {
	
	@Autowired
	private JwtService jwtService;
	
	
	@PostMapping({"/getToken"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
	
	@GetMapping("/test")
	public String test() {
		return "succesful";
	}
	
}
