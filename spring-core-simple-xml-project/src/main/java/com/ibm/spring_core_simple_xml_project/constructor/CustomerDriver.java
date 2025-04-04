package com.ibm.spring_core_simple_xml_project.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerDriver {
	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("myspring.xml");
		Customer c = (Customer) ap.getBean("customer");
		System.out.println(c);
	}
}
