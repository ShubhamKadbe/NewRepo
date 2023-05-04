package com.school.myschool.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.myschool.model.Student;
import com.school.myschool.serviceImpl.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudentData() {
		return studentServiceImpl.getAllStudentData();
	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<List<Student>> saveStudent(@RequestBody List<Student> studentList){
		return studentServiceImpl.saveStudent(studentList);
	}
	
	@DeleteMapping("/deleteStudent")
	public Map<String, String> deleteStudent(@RequestBody List<Student> studentList){
		return studentServiceImpl.deleteStudent(studentList);
	}
	
	
}
