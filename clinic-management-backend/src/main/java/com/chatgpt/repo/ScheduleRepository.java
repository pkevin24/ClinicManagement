package com.chatgpt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatgpt.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {

}
