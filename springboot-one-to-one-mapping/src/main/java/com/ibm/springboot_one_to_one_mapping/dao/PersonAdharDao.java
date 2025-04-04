package com.ibm.springboot_one_to_one_mapping.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.springboot_one_to_one_mapping.dto.Adhar;
import com.ibm.springboot_one_to_one_mapping.dto.Person;
import com.ibm.springboot_one_to_one_mapping.repository.AdharRepository;
import com.ibm.springboot_one_to_one_mapping.repository.PersonRepository;

@Repository
public class PersonAdharDao {
	@Autowired
	AdharRepository adharRepository;
	@Autowired
	PersonRepository personRepository;

	public Person savePersonAdharDao(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPersonAdharByPersonIdDao(int personId) {
		Optional<Person> optional= personRepository.findById(personId);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public Adhar getAdharPersonByAdharNumDao(long adharNum) {
		Optional<Adhar> optional= adharRepository.findById(adharNum);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public int deletePersonByPersonId(int personId) {
		if(personRepository.existsById(personId)) {
			 personRepository.deleteById(personId);
			 return 1;
		}else {
			return 0;
		}
	}
	public int deleteAdharByAdharNum(long adharNum) {
		Adhar adhar=adharRepository.findById(adharNum).get();
		if(adhar!=null) {
			adhar.getPerson().setAdhar(null);
			adharRepository.deleteById(adharNum);
			 return 1;
		}else { 
			return 0;
		}
	}
	
}

