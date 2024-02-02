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

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "rto_info")
@NamedQueries({ @NamedQuery(name = "readAll", query = "select e from RtoEntity e"),
		@NamedQuery(name = "readByEmail", query = "select e from RtoEntity e where e.emailId=:email"),
		@NamedQuery(name = "OTPlogin", query = "select e from RtoEntity e where e.emailId=:email and e.rtoOtp=:rtoOtp"),
		@NamedQuery(name = "login", query = "select e from RtoEntity e where e.emailId=:email and e.password=:password"),
		@NamedQuery(name = "findByState", query = "select e from RtoEntity e where e.state=:state")/*
																									 * ,
																									 * 
																									 * @NamedQuery(name
																									 * =
																									 * "updatePassword",
																									 * query =
																									 * "update  RtoEntity e set (e.password=:ps and e.confirmPassword=:cpsd) WHERE e.emailId=:mail"
																									 * )
																									 */ })
public class RtoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_id")
	private int id;
	@Column(name = "r_firstName")
	private String firstName;
	@Column(name = "r_lastName")
	private String lastName;
	@Column(name = "r_dob")
	private String dateOfBirth;
	@Column(name = "r_email")
	private String emailId;
	@Column(name = "r_mobileNumber")
	private long mobileNumber;
	@Column(name = "r_state")
	private String state;
	@Column(name = "r_place")
	private String place;
	@Column(name = "r_password")
	private String password;
	@Column(name = "r_confirmPassword")
	private String confirmPassword;
	@Column(name = "registereDateTime")
	private LocalDateTime registereDateTime;
	@Column(name = "rto_otp")
	private String rtoOtp;
	@Column(name = "activeOrDeactive")
	private String accountActiveOrDeActive;
	@Column(name = "failedCount")
	private int failedCount;
	private LocalDateTime otpRequestTime;
}
