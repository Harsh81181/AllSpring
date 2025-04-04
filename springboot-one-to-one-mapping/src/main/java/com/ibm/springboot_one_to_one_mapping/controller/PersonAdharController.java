package com.ibm.springboot_one_to_one_mapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot_one_to_one_mapping.dto.Person;
import com.ibm.springboot_one_to_one_mapping.response.ResponseStructure;
import com.ibm.springboot_one_to_one_mapping.service.PersonAdharService;

@RestController
@RequestMapping(value = "personAdhar")
public class PersonAdharController {

	@Autowired
	private PersonAdharService service;

	@PostMapping(value = "/savePersonAdhar/{person}")
	public ResponseStructure<Person> savePersonAdhar(@RequestBody Person person) {
		return service.savePersonAdharDao(person);
	}
	@GetMapping(value = "/getPersonAdharByPersonId/{personId}")
	public ResponseStructure<Person> getPersonAdharByPersonId(@PathVariable int personId) {
		return service.getPersonAdharByPersonIdService(personId);
	}
	@GetMapping("/getAdharPersonByAdharNum/{adharNum}")
	public ResponseStructure<Person> getAdharPersonByAdharNum(@PathVariable long adharNum) {
		return service.getAdharPersonByAdharNumService(adharNum);
	}
	@DeleteMapping("deletePersonByPersonId/{personId}")
	public ResponseStructure<String> deletePersonByPersonId(@PathVariable int personId) {
		return service.deletePersonByPersonId(personId);
	}
	@DeleteMapping("deleteAdharByAdharNum/{adharNum}")
	public ResponseStructure<String>  deleteAdharByAdharNum(@PathVariable long adharNum) {
		return service.deleteAdharByAdharNum(adharNum);
	}

}
