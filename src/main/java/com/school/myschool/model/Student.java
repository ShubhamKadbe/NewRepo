package com.school.myschool.model;


import org.springframework.lang.NonNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"ROLLNO", "AADHARNO", "EMAIL"})})
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lasttName")
	private String lastName;
	
	@Column(name = "std")
	private String std;
	
	@Column(name = "section")
	private String section;
	
	@Column(name = "rollNo")
	private String rollNo;
	
	@Column(name = "aadharNo")
	private String aadharNo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contactNo")
	private String contactNo;
	
	@Column(name = "DOB")
	private String dOB;
	
	@Column(name = "fatherName")
	private String fatherName;
	
	@Column(name = "motherName")
	private String motherName;
	
	@Column(name = "parentContactNo")
	private String parentContactNo;
	
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	@NonNull
	private Address address;

	public Student() {
	}

	public Student(Long id, String firstName, String lastName, String std, String section, String rollNo,
			String aadharNo, String email, String contactNo, String dOB, String fatherName, String motherName,
			String parentContactNo, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.std = std;
		this.section = section;
		this.rollNo = rollNo;
		this.aadharNo = aadharNo;
		this.email = email;
		this.contactNo = contactNo;
		this.dOB = dOB;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.parentContactNo = parentContactNo;
		this.address = address;
	}
	
	
	
}
