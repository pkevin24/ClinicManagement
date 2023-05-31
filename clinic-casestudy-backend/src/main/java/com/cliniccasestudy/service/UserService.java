package com.cliniccasestudy.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliniccasestudy.entity.User;
import com.cliniccasestudy.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User addUser(User user)
	{
		return userRepo.save(user);
	}
	
}
