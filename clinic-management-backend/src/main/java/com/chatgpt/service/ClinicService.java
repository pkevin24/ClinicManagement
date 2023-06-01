package com.chatgpt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatgpt.model.LoginReply;
import com.chatgpt.model.User;
import com.chatgpt.repo.UserRepository;
import com.chatgpt.util.jwtutil;

@Service
public class ClinicService {
	@Autowired
	private jwtutil util;
	
	@Autowired
	private UserRepository user;
public LoginReply getAuthenticated(String name, String pass) {
		
		Optional<User> u=Optional.ofNullable(user.findByUsername(name));
		if(u.isPresent())
		{
			if(u.get().getPassword().equals(pass))
			{
				String jwt=util.generateToken(name);
				LoginReply log=new LoginReply();
				log.setUserName(name);
				log.setJwt(jwt);
				return log;
			}
			return null;
		}
		return null;
	}
}
