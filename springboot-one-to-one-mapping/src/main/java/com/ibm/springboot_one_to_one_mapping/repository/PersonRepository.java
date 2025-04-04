package com.ibm.springboot_one_to_one_mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.springboot_one_to_one_mapping.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
