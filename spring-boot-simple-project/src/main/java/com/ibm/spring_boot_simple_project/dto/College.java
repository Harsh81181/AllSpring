package com.ibm.spring_boot_simple_project.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
public class College {
	@Id
	private int id;
	private String name;

	private String address;
	private String type;
	
	
	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", address=" + address + ", type=" + type + "]";
	}
	
	
	
}
