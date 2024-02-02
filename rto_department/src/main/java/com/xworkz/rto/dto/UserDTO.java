package com.xworkz.rto.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
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