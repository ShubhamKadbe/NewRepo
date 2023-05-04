package com.school.myschool.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.school.myschool.model.Student;

public interface StudentService {

	public ResponseEntity<List<Student>> getAllStudentData();
	
	public ResponseEntity<List<Student>> saveStudent(List<Student> studentList);

	public Map<String, String> deleteStudent(List<Student> studentList);
	
	public List<Student> getStudentsByRollNo(List<String> studentRollNoList);

}
