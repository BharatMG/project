package com.xworkz.rto.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDL {

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
	private String DLapplicationNumber;
	private String status;
	private String fileContentType;
	private String filename;
}
