package com.xworkz.rto.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userRTO_DL")
@NamedQueries({ @NamedQuery(name = "DLByState", query = "select e from UserDLEntity e where e.state=:dlstate"),
		@NamedQuery(name = "updateDLStatus", query = "update UserDLEntity e set e.status='DLApproved' where e.DLapplicationNumber=:DLappl"),
		@NamedQuery(name = "searchByApplication", query = "select e from UserDLEntity e where e.DLapplicationNumber=:DLapplicationNumber"),
		@NamedQuery(name = "searchAll", query = "select e from UserDLEntity e") })
public class UserDLEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String middleName;
	private String lastname;
	private String gender;
	private String dob;
	private String placeOfBirth;
	private String bloodGroup;
	private String contactNumber;
	private String passportNumber;
	private String presentAddress;
	private int presentPincode;
	private String permanentAddress;
	private String state;
	private String withnessFirstName;
	private String withnessMiddleName;
	private String withnesslastName;
	private String withnessRelationship;
	private String trainerName;
	private String trainerLicenseNo;
	private LocalDateTime userRegistereDateTime;
	@Column(name = "DL_number")
	private String DLapplicationNumber;
	@Column(name = "DL_status")
	private String status;
	private String fileContentType;
	private String filename;

}
