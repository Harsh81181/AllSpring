package com.ibm.spring_boot_simple_project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring_boot_simple_project.dao.CollegeDao;
import com.ibm.spring_boot_simple_project.dto.College;
import com.ibm.spring_boot_simple_project.response.ResponseStructure;
import com.ibm.spring_boot_simple_project.service.CollegeService;

@RestController
public class CollegeController {
	@Autowired
	private CollegeDao collegeDao;
	
	@Autowired
	private CollegeService service;
	
	@GetMapping(value = "/getTodaysDate")
	public String getData() {
		return LocalDate.now()+" Todays date";
	}
	@PostMapping(value = "/saveCollege")
	public ResponseStructure<College> saveCollege(@RequestBody College college) {
		return service.saveCollegeService(college);
		
	}
	@PostMapping(value = "/saveAllCollege")
	public List<College> saveAllCollege(@RequestBody List<College> colleges){
		return collegeDao.saveAllCollegeDao(colleges);
	}
	@GetMapping(value = "/getAllCollege")
	public ResponseEntity<List<College>> getAllCollege(){
		return new ResponseEntity<List<College>>(collegeDao.getAllCollegeDao(),HttpStatus.OK);
	}
	@GetMapping(value = "/fetchCollegeBYId/{college_id}")
	public ResponseStructure<College> fetchCollegeBYId(@PathVariable int college_id) {
		return service.fetchCollegeBYId(college_id);
	}
	@GetMapping(value = "/getAllCollegeByName/{name}")
	public List<College> getAllCollegeByName(@PathVariable String name){
		return collegeDao.getAllCollegeByNameDao(name);
	}
	@GetMapping(value = "/getCollegeByType/{type}")
	public List<College> getCollegeByType(@PathVariable String type){
		List<College> colleges= collegeDao.getCollegeByTypeDao(type);
		for(College college:colleges) {
			System.out.println(college);
		}
		return colleges;
	}
	@GetMapping(value = "getListLikeWord/{word}")
	public ResponseStructure<List<College>> FetchCollegeByNameLike(@PathVariable String word){
		return service.FetchCollegeByNameLike(word);
	}
	
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseStructure<String> deleteCollegeByIdController(@PathVariable int id){
		return service.deleteCollegeByIdService(id);
	}
	@PutMapping(value = "/updateCollege")
	public ResponseStructure<College> updateCollege(@RequestBody College college){
		return service.updateCollegeService(college);
	}
	@PutMapping(value = "/updateCollegeNameById/{id}/{name}")
	public ResponseStructure<College> updateCollegeNameById(@PathVariable int id,@PathVariable String name){
		return service.updateCollegeNameByIdService(id, name);
	}
}
