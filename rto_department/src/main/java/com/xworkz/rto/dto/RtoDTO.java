package com.xworkz.rto.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RtoDTO {
	private int id;
	@NotBlank
	@NotNull
	@Size(min = 3, max = 30, message = "check the name length,min=3 and max=30")
	private String firstName;
	@NotBlank
	@NotNull
	private String lastName;
	@NotBlank
	@NotNull
	private String dateOfBirth;
	@Email
	@NotBlank
	private String emailId;
	@Min(value = 1000000000L, message = "Phone must be min 10 digits")
	@Max(value = 9999999999L, message = "Phone can't be more than 10 digits")
	private long mobileNumber;
	private String state;
	private String place;
	@NotBlank
	private String password;
	private String confirmPassword;
	private LocalDateTime registereDateTime;
	private String rtoOtp;
	private String accountActiveOrDeActive;
	private int failedCount;
	private LocalDateTime otpRequestTime;
}
