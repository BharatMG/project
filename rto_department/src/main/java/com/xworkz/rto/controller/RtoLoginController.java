package com.xworkz.rto.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.dto.UserDL;
import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.mail.MailService;
import com.xworkz.rto.service.RtoDLService;
import com.xworkz.rto.service.RtoService;
import com.xworkz.rto.service.RtoUserService;
import com.xworkz.rto.util.Encrytion;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class RtoLoginController {

	public RtoDTO dto = null;

	@Autowired
	private MailService mailService;

	@Autowired
	private RtoService service;

	@Autowired
	private RtoUserService userService;

	@Autowired
	private RtoDLService userDL;

	@Autowired
	Encrytion encrypt1;

	@GetMapping("rto")
	public String admin(@RequestParam String admin, Model model) {
		System.out.println(admin);
		if (admin.equals("Admin")) {
			log.info("using loggers");
			return "admin";
		}
		if (admin.equals("LLR-Registeration")) {

			String state[] = { "Karnataka", "Maharashtra", "Kerala", "Odisha" };

			List<String> stateList = new ArrayList<String>(Arrays.asList(state));
			System.out.println(stateList);
			model.addAttribute("state", stateList);

			String Karnataka[] = { "Haveri", "Dharwad", "Bengaluru", "Mysuru" };
			String Odisha[] = { "Bhubaneswar", "Puri", "Cuttack" };
			String Maharashtra[] = { "Mumbai", "Pune", "Nagpur" };
			String Kerala[] = { "kochi", "munnar" };

			model.addAttribute("karnataka", Karnataka);
			model.addAttribute("odisha", Odisha);
			model.addAttribute("maharashtra", Maharashtra);
			model.addAttribute("kerala", Kerala);

			return "UserRegister";
		}
		if (admin.equals("SignUp")) {
			return "SignUp";
		}
		if (admin.equals("Rtologin")) {
			return "login";
		}
		if (admin.equals("LLR-Application Status")) {
			return "LLR-status";
		}
		if (admin.equals("Forgetten Password")) {
			return "forgetUserLogin";

		}
		if (admin.equals("DL-Registeration")) {
			return "DL-entry";
		}
		return "index";
	}

	@PostMapping("login")
	public String login(@RequestParam String emailId, @RequestParam String password, Model model) {
		// RtoDTO dto = service.login(emailId, password);
		RtoDTO dto = service.loginByEmail(emailId);
		log.info("using loggers to login the rto officer");
		if (dto.getEmailId().equalsIgnoreCase(emailId)
				&& encrypt1.decrypt(dto.getPassword()).equalsIgnoreCase(password)) {
			List<UserDTO> userDTOs = userService.searchByUserState(dto.getState());// Collections.sort(userDTOs,);
			List<UserDL> userDLs = userDL.searchByUserDL(dto.getState());
			if (dto != null) {
				model.addAttribute("dto", dto);
				model.addAttribute("state", userDTOs);
				model.addAttribute("state1", userDLs);

				model.addAttribute("dd", dto.getFirstName().toUpperCase());
				return "profile";
			}
		} else {
			model.addAttribute("pass", "invalid password");
			return "login";
		}
		return "login";
	}

	@PostMapping("checkemail")
	public String forgetPassword(
			/* @ModelAttribute RtoDTO dto, */ /* HttpServletRequest req, */ @RequestParam String rtoOtp, String otp,
			@RequestParam String emailId, /* @RequestParam String password, @RequestParam String confirmPassword, */
			Model model /* HttpSession session */) {
		RtoDTO dto = null;
		System.out.println("otp is      +" + otp);
		if (otp.equalsIgnoreCase("sendOtp")) {
			List<RtoDTO> dtos = service.readAll();
			for (RtoDTO rtoDTO : dtos) {
				if (rtoDTO.getEmailId().equals(emailId)) {
					dto = rtoDTO;
				}
			}
			if (dto != null) {
				int randomNumber = (int) ((Math.random() * 90000) + 10000);
				// boolean sendOTP =

				mailService.mailSend(emailId, String.valueOf(randomNumber));
				// if (sendOTP) {
				service.updateOTPbyId(dto, String.valueOf(randomNumber)); // update otp method
				model.addAttribute("emailId", emailId);
				model.addAttribute("pass", "otp sent successfully");
				/*
				 * else { model.addAttribute("err", "Error while sending otp"); }
				 */
			} else {
				model.addAttribute("err", "Invalid emailId");
			}
			return "forgetRtoLogin";
		} else if (otp.equalsIgnoreCase("next"))

		{
			dto = service.adminLogin(emailId, rtoOtp);
			if (dto != null) {
				model.addAttribute("emailId", emailId);
				model.addAttribute("pass", "Otp verified");
				return "ResetPassword";
			} else {
				model.addAttribute("err", "Invalid Otp");
				return "forgetRtoLogin";
			}

		}
		return "forgetRtoLogin";

	}

	@PostMapping("updatePassword")
	public String updatePassword(@RequestParam String emailId, @RequestParam String password,
			@RequestParam String confirmPassword, Model model) {
		RtoDTO dto = null;

		List<RtoDTO> dtos = service.readAll();
		for (RtoDTO rtoDTO : dtos) {
			if (rtoDTO.getEmailId().equals(emailId)) {
				dto = rtoDTO;
			}
		}
		if (dto != null) {
			service.updatePassword(dto, password, confirmPassword);
			System.out.println("Decrypted pass: " + encrypt1.decrypt(dto.getPassword()));
			model.addAttribute("pass", "updatePassword successfully");
		} else {
			model.addAttribute("err", "updatePassword not valid");
		}
		return "login";
	}

	@PostMapping("adminlogin")
	public String adminLogin(@RequestParam String emailId, String send, @RequestParam String rtoOtp, Model model) {

		if (send.equalsIgnoreCase("sendOtp")) {
			List<RtoDTO> dtos = service.readAll();
			for (RtoDTO rtoDTO : dtos) {
				if (rtoDTO.getEmailId().equals(emailId)) {
					dto = rtoDTO;
				}
			}
			if (dto != null) {
				System.out.println("***************************" + dto.getEmailId() + "*************************");
				int randomNumber = (int) ((Math.random() * 90000) + 10000);
				/* boolean sendOTP = */ mailService.mailSend(emailId, String.valueOf(randomNumber));
				// if (sendOTP) {
				service.updateOTPbyId(dto, String.valueOf(randomNumber));
				model.addAttribute("em", emailId);
				model.addAttribute("pass", "otp sent successfully");
				/*
				 * } else { model.addAttribute("err", "Error while sending otp"); }
				 */ } else {
				model.addAttribute("err", "Invalid emailId");
				return "admin";
			}
		} else if (send.equalsIgnoreCase("writeOtp")) {

			List<RtoDTO> dtos = service.readAll();
			for (RtoDTO rtoDTO : dtos) {
				if (rtoDTO.getEmailId().equals(emailId)) {
					dto = rtoDTO;
				}
			}
			model.addAttribute("em", emailId);
			if (dto != null) { // if founds
				if (encrypt1.decrypt(dto.getRtoOtp()).equalsIgnoreCase(rtoOtp)) {
					if (Duration.between(dto.getOtpRequestTime(), LocalDateTime.now()).getSeconds() < (1 * 60)) {
						dto.setFailedCount(0);
						dto.setAccountActiveOrDeActive("active");
						service.updateLoginCount(dto);
						model.addAttribute("em", dto.getFirstName());
						System.err.println("=================---------------" + dto);
						log.info("correct otp,login successfully");
						return "adminProfile";
					} else {
						model.addAttribute("timeout", "otp expire !! please regenerate otp and try again");
						return "admin";
					}
				} else {

					if (dto.getFailedCount() == 3) {
						dto.setAccountActiveOrDeActive("inactive");
						service.updateLoginCount(dto);
						model.addAttribute("adminLoginBlocked", "account blocked,Resend OTP");
					} else {
						if (dto.getFailedCount() <= 3) {
							dto.setFailedCount(dto.getFailedCount() + 1);
							service.updateLoginCount(dto);
							model.addAttribute("err", "wrong otp");
						}
						return "admin";
					}
				}
			}
			// return "admin";
		}
		return "admin";
	}

	@PostMapping("verifyotp")
	public String getOtp(@RequestParam String emailId, @RequestParam String rtoOtp, Model model) {
		RtoDTO dto = service.adminLogin(emailId, rtoOtp);
		if (dto != null) {
			return "adminProfile";
		} else {
			model.addAttribute("err", "Invalid Otp");
			return "admin";
		}
		/*
		 * if (send == true) { System.out.println("mail Send Sucessfully");
		 * model.addAttribute("send", " mail Send Successfully"); return "admin"; }
		 */
	}
}

//	@GetMapping("getCities")
//	public List<Object> getCities(@RequestParam String state) {
//		List<Object> list = new ArrayList<Object>();
//		if(state.equalsIgnoreCase("Karnataka")) {
//			String Karnataka[] = { "Haveri", "Dharwad", "Bengaluru", "Mysuru" };
//			list.add(Arrays.asList(Karnataka));
//		}else if(state.equalsIgnoreCase("Odisha")) {
//			String Odisha[] = { "Bhubaneswar", "Puri", "Cuttack" };
//			list.add(Arrays.asList(Odisha));
//		}else if(state.equalsIgnoreCase("Maharashtra")) {
//			String Maharashtra[] = { "Mumbai", "Pune", "Nagpur" };
//			list.add(Arrays.asList(Maharashtra));
//		}else if(state.equalsIgnoreCase("Kerala")) {
//			String Kerala[] = { "kochi", "munnar" };
//			list.add(Arrays.asList(Kerala));
//		}	
//		
//		return list;
//	}
