package com.ibm.springboot_one_to_one_mapping.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.springboot_one_to_one_mapping.response.ResponseStructure;

@ControllerAdvice
public class PersonAdharExceptionHandler {

	@Autowired
	ResponseStructure<String> rs;
	
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> IdNotFoundException(IdNotFoundException e){
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Data not found");
		rs.setData(e.getMessage());
		e.printStackTrace();
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
}
