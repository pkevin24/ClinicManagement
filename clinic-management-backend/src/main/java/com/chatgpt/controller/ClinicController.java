package com.chatgpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chatgpt.model.LoginReply;
import com.chatgpt.service.ClinicService;

@RestController
public class ClinicController {
	
	@Autowired
	private ClinicService serv;
	
	@GetMapping("/gettoken/{id}/{pass}")
	public LoginReply getToken(@PathVariable("id") String name, @PathVariable("pass") String pass)
	{
		return serv.getAuthenticated(name,pass);
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "done";
	}

}
