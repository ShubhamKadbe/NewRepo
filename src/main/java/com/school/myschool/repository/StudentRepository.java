package com.school.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.myschool.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query(value = "select * from Student where ROLLNO in (:studentRollNoList)", nativeQuery = true)
	List<Student> getByRollNo(@Param("studentRollNoList") List<String> studentRollNoList);

	@Query(value = "delete s,a from Student s INNER JOIN Address a ON s.rollno = a.parentobjectid WHERE s.rollno In (:studentRollNoList)", nativeQuery = true)
	List<Student> deleteStudentsByRollNo(@Param("studentRollNoList") List<String> studentRollNoList);
}
