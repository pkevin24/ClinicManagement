package com.chatgpt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	private int id;
	@Column(name = "clinic_id")
	private int clinic_id;
	@Column(name = "doctor_id")
	private int doctor_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(int clinic_id) {
		this.clinic_id = clinic_id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", clinic_id=" + clinic_id + ", doctor_id=" + doctor_id + "]";
	}

}
