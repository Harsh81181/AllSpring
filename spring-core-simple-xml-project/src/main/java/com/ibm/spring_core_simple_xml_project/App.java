package com.ibm.spring_core_simple_xml_project;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public void m1() {
    	System.out.println("Good Morning , India! "+LocalDateTime.now());
    }
     
    public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("myspring.xml");
		App app= (App)applicationContext.getBean("myApp");
		app.m1();
    	
	}
}
