package com.ibm.spring_core_simple_xml_project.interfaces;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
public static void main(String[] args) {
	
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("myspring.xml");
	
	Flipkart flipkart= (Flipkart) applicationContext.getBean("flipkart");
	Paytm paytm= (Paytm) applicationContext.getBean("paytm");
	
	paytm.ticketBooking();
	flipkart.hotelBooking();
}
}
