package com.ibm.springboot_one_to_one_mapping.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ibm.springboot_one_to_one_mapping.dao.PersonAdharDao;
import com.ibm.springboot_one_to_one_mapping.dto.Adhar;
import com.ibm.springboot_one_to_one_mapping.dto.Person;
import com.ibm.springboot_one_to_one_mapping.exception.IdNotFoundException;
import com.ibm.springboot_one_to_one_mapping.response.ResponseStructure;

@Service
public class PersonAdharService {
	@Autowired
	private PersonAdharDao dao;
	@Autowired
	ResponseStructure<Person> responseStructure;
	@Autowired
	private ResponseStructure<String> structure;
//	@Autowired
//	ResponseStructure<Adhar> structure;

	public ResponseStructure<Person> savePersonAdharDao(Person person) {
		person.setAge(Period.between(person.getDob(), LocalDate.now()).getYears());
		Person p1 = dao.savePersonAdharDao(person);
		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Person and Adhar are saved");
		responseStructure.setData(p1);
		return responseStructure;
	}

	public ResponseStructure<Person> getPersonAdharByPersonIdService(int personId) {
		Person p1 = dao.getPersonAdharByPersonIdDao(personId);
		if (p1 != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Person Found with given Id{" + personId + "}");
			responseStructure.setData(p1);
			return responseStructure;
		} else {
			throw new IdNotFoundException("given personId{" + personId + "} not found in database");
		}
	}

	public ResponseStructure<Person> getAdharPersonByAdharNumService(long adharNum) {
		Adhar a1 = dao.getAdharPersonByAdharNumDao(adharNum);
		if (a1 != null) {
			responseStructure.setData(a1.getPerson());
			responseStructure.setMessage("Person & Adhar Found with given number{" + adharNum + "}");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			return responseStructure;
		} else {
			throw new IdNotFoundException("Given Adhar Number{" + adharNum + "} not found in database");
		}
	}

	public ResponseStructure<String> deletePersonByPersonId(int personId) {
		if (dao.deletePersonByPersonId(personId) == 1) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("ID has found");
			structure.setData("Person record has deleted");
			return structure;
		} else {
			throw new IdNotFoundException("Given personId{" + personId + "} not found in database");
		}
	}
	
	public ResponseStructure<String>  deleteAdharByAdharNum(long adharNum) {
		if(dao.deleteAdharByAdharNum(adharNum)==1) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("ID has found");
			structure.setData("Adhar record has deleted");
			return structure;
		}else {
			throw new IdNotFoundException("Given adharNumber{" + adharNum + "} not found in database");
		}
	}

}
