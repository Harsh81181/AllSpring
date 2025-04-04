package com.ibm.spring_boot_simple_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ibm.spring_boot_simple_project.dao.CollegeDao;
import com.ibm.spring_boot_simple_project.dto.College;
import com.ibm.spring_boot_simple_project.exception.IdNotFoundException;
import com.ibm.spring_boot_simple_project.exception.NameNotFoundException;
import com.ibm.spring_boot_simple_project.response.ResponseStructure;

@Service
public class CollegeService {
	@Autowired
	private CollegeDao dao=new CollegeDao();
	
	@Autowired
	private ResponseStructure<College> structure;
	@Autowired
	private ResponseStructure<List<College>> structure2;
	
	@Autowired
	private ResponseStructure<String> structure3;
	
	public ResponseStructure<College> saveCollegeService(College college){
		College college2=dao.saveCollegeDao(college);
		if(college2!=null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("College stored");
			structure.setData(college2);
			return structure;
		}
		else {
			structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			structure.setMessage("College is not stored");
			structure.setData(college2);
			return structure;
		}
	}
	
	public ResponseStructure<College> fetchCollegeBYId(int id){
		College college=dao.fetchCollegeBYIdDao(id);
		if(college!=null) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Object of given id has found");
			structure.setData(college);
			return structure;
		}
		else {
//			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("given id is not found");
//			structure.setData(college);
//			return structure;
			throw new IdNotFoundException("ID{"+id+"} not found in database");
		}
	}
	
	public ResponseStructure<List<College>> FetchCollegeByNameLike(String word){
		List<College> colleges=dao.FetchCollegeByNameLike(word);
		if(!colleges.isEmpty()) {
			structure2.setStatusCode(HttpStatus.FOUND.value());
			structure2.setMessage("CollegeName of given word has found");
			structure2.setData(colleges);
			return structure2;
		}else {
//			structure2.setStatusCode(HttpStatus.NOT_FOUND.value());
//			structure2.setMessage("given word is not found in any name");
//			structure2.setData(colleges);
//			return structure2;
			throw new NameNotFoundException("Name{"+word+"} not found in database");
		}
	}
	
	public ResponseStructure<String> deleteCollegeByIdService(int id){
		if(dao.deleteCollegeById(id)==1) {
		structure3.setStatusCode(HttpStatus.OK.value());
		structure3.setMessage("ID has found");
		structure3.setData("College record has deleted");
		return structure3;
		}
		else {
			throw new IdNotFoundException("ID{"+id+"} not found in database");
//			structure3.setStatusCode(HttpStatus.NOT_FOUND.value());
//			structure3.setMessage("ID has not found");
//			structure3.setData("College record can't be deleted");
//			return structure3;
			}
	}
	
	public ResponseStructure<College> updateCollegeService(College college){
		College college1=dao.fetchCollegeBYIdDao(college.getId());
		if(college1!=null) {
			dao.saveCollegeDao(college);
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("data successfully update");
			structure.setData(college);
			return structure;
		}else {
			throw new IdNotFoundException("ID{"+college.getId()+"} not found in database");
		}
	}
		
	public ResponseStructure<College> updateCollegeNameByIdService(int id,String name){
		College college1=dao.fetchCollegeBYIdDao(id);
		if(college1!=null) {
			college1.setName(name);
			dao.saveCollegeDao(college1);
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("data successfully update");
			structure.setData(college1);
			return structure;
		}else {
			throw new IdNotFoundException("ID{"+id+"} not found in database");
		}
	}
	
}
