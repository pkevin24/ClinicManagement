package com.chatgpt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatgpt.model.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

}
