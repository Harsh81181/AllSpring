package com.jsp.springboot_first_assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_first_assignment.dao.StudentSubjectDao;
import com.jsp.springboot_first_assignment.dto.Student;
import com.jsp.springboot_first_assignment.dto.Subject;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentSubjectDao dao;
	@PostMapping("/addAllStudent")
	public List<Student> addAllStudent(@RequestBody List<Student> students){
		return dao.addAllStudent(students);
	}
	
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return dao.addStudent(student);
    }
    
    @GetMapping("/getStudentsBySubjects")
    public List<Student> getStudentsBySubjects(@RequestParam List<String> subjects) {
        return dao.getStudentsBySubjects(subjects);
    }
	
    @DeleteMapping("/deleteFirst5")
    public void deleteFirst5StudentsBySubject(@RequestParam String subjectName) {
        dao.deleteFirst5StudentsBySubject(subjectName);
    }

    @PostMapping("/addOrUpdateSubject")
    public Subject addOrUpdateSubject(@RequestBody Subject subject) {
        return dao.addOrUpdateSubject(subject);
    }
}
