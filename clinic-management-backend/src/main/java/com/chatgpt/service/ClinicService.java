package com.chatgpt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatgpt.model.Clinic;
import com.chatgpt.model.Doctor;
import com.chatgpt.model.LoginReply;
import com.chatgpt.model.Schedule;
import com.chatgpt.model.User;
import com.chatgpt.repo.ClinicRepository;
import com.chatgpt.repo.DoctorRepository;
import com.chatgpt.repo.ScheduleRepository;
import com.chatgpt.repo.UserRepository;
import com.chatgpt.util.jwtutil;
import com.google.gson.Gson;

@Service
public class ClinicService {
	@Autowired
	private jwtutil util;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ScheduleRepository schRepo;
	
	@Autowired
	private ClinicRepository cliRepo;
	
	@Autowired
	private DoctorRepository docRepo;
	
	@Autowired
	private User user;

	public LoginReply getAuthenticated(String name, String pass) {

		Optional<User> u = Optional.ofNullable(userRepo.findByUsername(name));
		if (u.isPresent()) {
			if (u.get().getPassword().equals(pass)) {
				String jwt = util.generateToken(name);
				LoginReply log = new LoginReply();
				log.setUserName(name);
				log.setJwt(jwt);
				return log;
			}
			return null;
		}
		return null;
	}

	public String register(User user) {
		try {
			Optional<User> res = Optional.ofNullable(this.userRepo.findByUsername(user.getUsername()));
			if (res.isPresent()) {
				return "Username already exists";
			}
			this.userRepo.save(user);
			return "User created successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public Map<Clinic,List<Doctor>> getHomePageData()
	{
		List<Schedule> schList=schRepo.findAll();
		Map<Clinic,List<Doctor>> result=new HashMap<>();
		for(Schedule sch:schList)
		{
			Clinic cli=cliRepo.findById(sch.getClinic_id()).get();
			Doctor doc=docRepo.findById(sch.getDoctor_id()).get();
			List<Doctor> temp=null;
			if(result.containsKey(cli))
			{
				temp=result.get(cli);
				temp.add(doc);
			}
			else
			{
				temp=new ArrayList<>();
				temp.add(doc);
			}
			result.put(cli, temp);
		}
		System.out.print(new Gson().toJson(result));
		return result;
	}
}
