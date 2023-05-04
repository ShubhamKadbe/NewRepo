package com.school.myschool.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.myschool.model.Address;
import com.school.myschool.model.Student;
import com.school.myschool.repository.StudentRepository;
import com.school.myschool.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public ResponseEntity<List<Student>> getAllStudentData() {
		return ResponseEntity.ok().body(studentRepository.findAll());
	}

	@Override
	public ResponseEntity<List<Student>> saveStudent(List<Student> studentList) {
		return ResponseEntity.ok().body(studentRepository.saveAll(studentList));
	}

	@Override
	public Map<String, String> deleteStudent(List<Student> studentList) {
		List<String> studentRollNoList = studentList.stream().map(Student::getRollNo).collect(Collectors.toList());
		List<Student> existingStudents = studentRepository.getByRollNo(studentRollNoList);

		// filtering out non existing roll nos from existing roll nos
		List<String> nonexistingRollNoList = studentRollNoList.stream()
				.filter(rollNo -> existingStudents.stream().noneMatch(student -> student.getRollNo().equals(rollNo)))
				.collect(Collectors.toList());

//		List<Address> studentAddressList = existingStudents.stream().map(Student :: getAddress).collect(Collectors.toList());
		if (!nonexistingRollNoList.isEmpty()) {
			return Collections.singletonMap("Failed", "Student Roll Nos " + nonexistingRollNoList + " Do not exists");
		}
//		studentRepository.deleteStudentsByRollNo(existingStudents.stream().map(Student :: getRollNo).collect(Collectors.toList()));
		studentRepository.deleteAllInBatch(existingStudents);
		return Collections.singletonMap("Success", "Successfully deleted " + existingStudents.size() + " Students");
	}

	@Override
	public List<Student> getStudentsByRollNo(List<String> studentRollNoList) {
		return studentRepository.getByRollNo(studentRollNoList);
	}

}
