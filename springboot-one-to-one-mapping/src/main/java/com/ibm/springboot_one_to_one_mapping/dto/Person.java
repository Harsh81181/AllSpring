package com.ibm.springboot_one_to_one_mapping.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person  {

	@Id
	private int id;
	private String name;
	private LocalDate dob;
	private int age;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	@JsonManagedReference
	private Adhar adhar;
//	@Override
//	public String toString() {
//		return "Person [id=" + id + ", name=" + name + ", dob=" + dob + ", age=" + age +"]";
//	}
	
	
}
