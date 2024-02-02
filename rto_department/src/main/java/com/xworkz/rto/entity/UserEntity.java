package com.xworkz.rto.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "userrto_info")
@NamedQueries({ @NamedQuery(name = "readuser", query = "select e from UserEntity e"),
		@NamedQuery(name = "searchByState", query = "select e from UserEntity e where e.state=:LLRstate"),
		@NamedQuery(name = "userlogin", query = "select e from UserEntity e where (e.applicationNumber=:app or e.contactNumber=:app) and e.dob=:dob"),
		@NamedQuery(name = "updateStatus", query = "update  UserEntity e set e.status='Approved' WHERE e.applicationNumber=:appNum"),
		@NamedQuery(name = "getApplicationNumber", query = "select e from UserEntity e where e.applicationNumber=:appNum") })
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String state;
	private String country;
	private String dob;
	private int age;
	private String bloodGroup;
	private String qualification;
	private String placeOfBirth;
	private String rtoOffice;
	private String email;
	private long contactNumber;
	private long aadharNumber;
	private String presentAddress;
	private String permanentAddress;
	private int presentPincode;
	private int permanentPincode;
	private boolean organDonation;
	private LocalDateTime userRegistereDateTime;
	private String applicationNumber;
	private String status;
}