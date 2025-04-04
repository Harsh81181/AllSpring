package com.ibm.spring_core_simple_xml_project.interfaces;

public class Paytm  implements  MApp{
	@Override
	public void hotelBooking() {

		System.out.println("Hotel Book from paytm");	
	}
	@Override
	public void ticketBooking() {
		System.out.println("ticket Book from paytm");
		
	}
}