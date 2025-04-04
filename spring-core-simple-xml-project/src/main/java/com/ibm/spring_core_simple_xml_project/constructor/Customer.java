package com.ibm.spring_core_simple_xml_project.constructor;

public class Customer {

	private int id;
	private String name;
	private String email;

	public Customer(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
