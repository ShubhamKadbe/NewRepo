package com.school.myschool.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "parentObjectId", nullable = false)
	private String parentObjectId;

	private char type;

	private String houseName;

	private String area;

	private String city;

	private String pinCode;

	private String state;

	private String country;

	private String landmark;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parentObjectId", referencedColumnName = "rollno", insertable = false, updatable = false)
	private Student student;

	public Address() {
	}

	public Address(Long id, String parentObjectId, char type, String houseName, String area, String city,
			String pinCode, String state, String country, String landmark) {
		super();
		this.id = id;
		this.parentObjectId = parentObjectId;
		this.type = type;
		this.houseName = houseName;
		this.area = area;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
		this.landmark = landmark;
	}

}
