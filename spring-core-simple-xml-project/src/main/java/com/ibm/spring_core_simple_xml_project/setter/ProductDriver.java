package com.ibm.spring_core_simple_xml_project.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductDriver {
public static void main(String[] args) {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("myspring.xml");
	
	  Product p=(Product) applicationContext.getBean("product");
	  System.out.println(p.getId()); System.out.println(p.getName());
	 System.out.println("-----------Bean of List of Product------------------");
	Products products=(Products) applicationContext.getBean("products");
	for (Product product:products.getProducts()) {
		System.out.println(product);
	}
}
}
