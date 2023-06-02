package com.chatgpt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	@Id
	@Column(name="id")
	private int id;
	private String name;
	private String speciality;

}
