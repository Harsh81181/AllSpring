package com.ibm.spring_boot_simple_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.spring_boot_simple_project.dto.College;
import com.ibm.spring_boot_simple_project.repository.CollegeRepository;

@Repository
public class CollegeDao {

	@Autowired
	CollegeRepository collegeRepository;

	public College saveCollegeDao(College college) {
		return collegeRepository.save(college);
	}

	public List<College> saveAllCollegeDao(List<College> colleges) {
		return collegeRepository.saveAll(colleges);
	}

	public List<College> getAllCollegeDao() {
		return collegeRepository.findAll();
	}

	public College fetchCollegeBYIdDao(int id) {
		Optional<College> optional = collegeRepository.findById(id);
		return optional.isPresent()?optional.get():null;
		// if (optional.isPresent()) {
		// 	return optional.get();
		// } else {
		// 	return null;
		// }
	}

	public List<College> getAllCollegeByNameDao(String name) {
		return collegeRepository.findByName(name);
	}

	public List<College> getCollegeByTypeDao(String type) {
		return collegeRepository.getCollegeByType(type);
	}

	public List<College> FetchCollegeByNameLike(String word) {
		return collegeRepository.getCollegeBySimiliarWord(word);
	}
	
	public int deleteCollegeById(int id) {
		if(collegeRepository.existsById(id)) {
			collegeRepository.deleteById(id);
			return 1;
		}else {
			return 0;
		}
	}
}
