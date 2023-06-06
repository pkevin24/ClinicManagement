package com.chatgpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatgpt.model.LoginReply;
import com.chatgpt.model.User;
import com.chatgpt.service.ClinicService;
import com.google.gson.Gson;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin("*")
public class ClinicController {
	
	@Autowired
	private ClinicService serv;
	
	@GetMapping("/gettoken/{id}/{pass}")
	public ResponseEntity<LoginReply> getToken(@PathVariable("id") String name, @PathVariable("pass") String pass)
	{
		LoginReply res=serv.getAuthenticated(name,pass);
		if(res==null || res.isEmpty())
		{
			return new ResponseEntity<LoginReply>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<LoginReply>(res,HttpStatus.OK);
	}
	
//	@GetMapping("/getHomePageData")
//	public ResponseEntity<List<Clinic>>
//	{
//		
//	}
	
	@PostMapping("/gettoken/register")
	public String register(@RequestBody User user)
	{
		String res=serv.register(user);
		ResponseEntity<String> reply=null;
		switch(res)
		{
		case "User created successfully":
			reply=new ResponseEntity<String>(res, HttpStatus.OK);
			break;
		case "Username already exists":
			reply= new ResponseEntity<String>(res,HttpStatus.BAD_REQUEST);
			break;
		default:
			reply= new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new Gson().toJson(reply);
	}
}
