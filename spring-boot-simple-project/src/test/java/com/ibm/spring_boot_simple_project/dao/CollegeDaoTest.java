package com.ibm.spring_boot_simple_project.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ibm.spring_boot_simple_project.dto.College;
import com.ibm.spring_boot_simple_project.repository.CollegeRepository;
@ExtendWith(MockitoExtension.class)
class CollegeDaoTest {
	@Mock
	CollegeRepository collegeRepository;
	
	@InjectMocks
	CollegeDao dao;
	
	College college;
	
	@BeforeEach
	void createCollegeObject() {
		college=College.builder().id(124).name("miya bhai").type("A").address("purana adda").build();
	}

	@Test
	public void saveCollegeDaoTest() {
		when(collegeRepository.save(college)).thenReturn(college);
		College college1=dao.saveCollegeDao(college);
		assertEquals(124, college1.getId());
		assertEquals("miya bhai", college1.getName());
		assertEquals("A", college1.getType());
		assertEquals("purana adda", college1.getAddress());
	}
	
	@Test
	public void fetchCollegeBYIdTest() {
		when(collegeRepository.findById(124)).thenReturn(Optional.of(college));
		College college1= dao.fetchCollegeBYIdDao(124);
		assertEquals("miya bhai", college1.getName());
	}

	
}
