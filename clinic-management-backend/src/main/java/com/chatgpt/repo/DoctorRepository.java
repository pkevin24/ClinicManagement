package com.chatgpt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatgpt.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
