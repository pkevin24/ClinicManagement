package com.chatgpt.model;

import java.util.Objects;

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
	@Column(name="doctor_name")
	private String name;
	@Column(name="speciality")
	private String speciality;
	@Column(name="fees")
	private int fees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", speciality=" + speciality + ", fees=" + fees + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(fees, id, name, speciality);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return fees == other.fees && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(speciality, other.speciality);
	}
	
}
