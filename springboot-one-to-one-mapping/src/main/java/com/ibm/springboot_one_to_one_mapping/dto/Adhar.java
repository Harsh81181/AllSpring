package com.ibm.springboot_one_to_one_mapping.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Adhar {
	@Id
	private long adharnumber;
	private String fathername;
	private String address;
	@OneToOne(mappedBy = "adhar")
	@JsonBackReference
	private Person person;
	
	
}
