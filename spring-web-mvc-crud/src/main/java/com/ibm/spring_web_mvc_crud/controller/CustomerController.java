package com.ibm.spring_web_mvc_crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.spring_web_mvc_crud.dao.CustomerDao;
import com.ibm.spring_web_mvc_crud.dto.User;

@Controller
public class CustomerController {
	@Autowired
	private CustomerDao dao;
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String openIndex() {
		return "index";
	}
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public ModelAndView opernRegister() {
		return new ModelAndView("register").addObject("user",new User());
	}
	@RequestMapping(value = "/registerUser",method = RequestMethod.POST)
	public ModelAndView registerUserController(User user) {
		System.out.println(user);
		if(dao.findById(user.getId())!=null) {
			dao.updateUser(user);
			return displayUserController();
		}
		else{
			dao.saveCustomerDao(user);
			return new ModelAndView("register").addObject("user",new User());
	}
	}
	
	@RequestMapping(value = "/display",method = RequestMethod.GET)
	public ModelAndView displayUserController() {
		return new ModelAndView("display").addObject("users",dao.getAllUser());

	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public ModelAndView deleteUserById(@RequestParam("id") int id) {
		System.out.println(id);
		dao.deleteById(id);
		return displayUserController();
	}


	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public ModelAndView updateUserById(@RequestParam("id") int id) {
	 return new ModelAndView("register").addObject("user",dao.findById(id));
	}
	    
}
