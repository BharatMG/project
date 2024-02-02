package com.xworkz.rto.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.rto.dto.UserDL;
import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.service.RtoDLService;
import com.xworkz.rto.service.RtoUserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class UserController {

	@Autowired
	private RtoUserService userService;

	@Autowired
	RtoDLService dlService;

	@PostMapping("user")
	public String userSave(Model model, @ModelAttribute UserDTO userDTO) {
		List<UserDTO> dtos = userService.readUser();
		log.info("using loggers to login the user details");

		System.out.println("usersave controller method");
		for (UserDTO userDTO2 : dtos) {
			if (userDTO2.getEmail().equalsIgnoreCase(userDTO.getEmail())) {
				model.addAttribute("error", "* email already exist");
				if (userDTO2.getContactNumber() == userDTO.getContactNumber()) {
					model.addAttribute("error1", "* number is already exists");
					return "UserRegister";
				}
			} else {
				boolean save = userService.checkSave(userDTO);

				String state[] = { "karnataka", "Ap", "tamilNadu", "Goa" };
				List<String> stateList = new ArrayList<String>(Arrays.asList(state));
				System.out.println(stateList);
				model.addAttribute("dto", userDTO);
				model.addAttribute("message", "successfully registered");
				model.addAttribute("applicationNumber", "applicationNumber is " + userDTO.getApplicationNumber());
				return "UserRegister";
			}
		}
		return "UserRegister";
	}

	@GetMapping("userState")
	public String userState(@RequestParam String state, Model model) {
		List<UserDTO> userDTOs = userService.searchByUserState(state);
		model.addAttribute("state", userDTOs);
		return "profile";
	}

	@GetMapping("appStaus")
	public String userStatus(@RequestParam String apporcontact, String dob, Model model) {
		if (dob != null) {
			UserDTO userDTO = userService.userLogin(apporcontact, dob);
			// List<UserDL> readAll = dlService.readAll(); // dl details
			model.addAttribute("d", userDTO);
			// model.addAttribute("dlDetails", readAll);
			return "UserProfile";
		} else {
			model.addAttribute("msg", "invalid login");
			return "LLR-status";
		}
	}

	@GetMapping("updateUserStatus")
	public String updateStatus(@RequestParam int id, /* @RequestParam String state, */ Model model) {
		boolean update = userService.updateId(id);
		if (update == true) {
			model.addAttribute("updateMessage", "updated successfully..........");
			model.addAttribute("u", update);
			return "profile";
		} else {
			model.addAttribute("updateMessage", "...not updated ..........");
			return "profile";
		}
	}

	@GetMapping("DLform1")
	public String checkApplicationNumber(@ModelAttribute UserDTO dto, Model model) {
		List<UserDTO> dtos = userService.readUser();
		// System.err.println(dtos);
		for (UserDTO userDTO3 : dtos) {
			if (userDTO3 != null) {
				System.err.println(userDTO3);
				if (userDTO3.getApplicationNumber().equalsIgnoreCase(dto.getApplicationNumber())) {
					System.err.println("applicationNumber is :" + dto.getApplicationNumber());
					return "DL-applicationForm";
				}
			} else {
				model.addAttribute("err", "applicationNumber not exist");
			}
			model.addAttribute("err", "applicationNumber is invalid");
			return "DL-entry";
		}
		return "DL-entry";
	}

	@GetMapping("DLform")
	public String checkApplicationNumber(@RequestParam String applicationNumber, Model model) {
		UserDTO dtos = userService.checkApplicationNumber(applicationNumber);
		model.addAttribute("app", dtos);
		return "DL-applicationForm";
	}

	@PostMapping("dlSave")
	public String userDLsave(Model model, /* @RequestParam("filename") MultipartFile filename */
			@ModelAttribute UserDL userDL) {
		model.addAttribute("app1", userDL.getDLapplicationNumber());
		dlService.dlSave(userDL);
		System.err.println(userDL);
		model.addAttribute("save", "dl application submitted successfully");
		model.addAttribute("appNo", userDL.getDLapplicationNumber());
		return "uploadFiles";
	}

//	@PostMapping("/upload")
	public String uploadFile(@RequestParam MultipartFile file, @RequestParam String dlApplicationNumber, Model model) {
		UserDL dl = dlService.searchByDLAplication(dlApplicationNumber);

		model.addAttribute("m", dlApplicationNumber);
		System.err.println(dlApplicationNumber);
		System.out.println("Upload File Running ");
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload");
			return "index";
		}
		try {

			String fileContentType = file.getContentType();
			dl.setFileContentType(fileContentType);

			String filename = file.getOriginalFilename();
			dl.setFilename(filename);

			System.out.println("File Name is   : " + filename + "   content type is    " + fileContentType);
			byte[] bytes = file.getBytes();
			Path path = Paths.get("D://filesave//" + file.getOriginalFilename());
			Files.write(path, bytes);
			dlService.updateId(dl);
			model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
			model.addAttribute("message", "dl is successfully completed");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "uploadFiles";
	}

	@GetMapping("dl-info")
	public String userDLState(Model model, @RequestParam String state) {
		List<UserDL> userDLs = dlService.searchByUserDL(state);
		model.addAttribute("state1", userDLs);
		return "profile";

	}

	@GetMapping("updateDLStatus") // update the dl status as approved
	public String updateDLStatus(@RequestParam int id, Model model) {
		boolean update = dlService.updateDLId(id);
		model.addAttribute("updateDL", "status updated successfully");
		model.addAttribute("status", update);
		return "profile";
	}

	@GetMapping("DLStatusUpdate")
	public String updateDLStatus(String DLapplicationNumber, Model model) {
		dlService.updateDLStatus(DLapplicationNumber);
		model.addAttribute("DLstatus", "DL staus is approved");
		return "profile";
	}

//	@GetMapping("/download")
	public String downloadFile(HttpServletResponse response, @RequestParam String DLapplicationNumber, Model model)
			throws FileNotFoundException {
		List<UserDL> readAll = dlService.readAll();
		for (UserDL userDL : readAll) {
			if (userDL.getDLapplicationNumber().equals(DLapplicationNumber)) {

				if (userDL.getStatus().equalsIgnoreCase("approved")) {

					// Path path = Paths.get("D://filesave//" + userDL.getFilename());
					// System.out.println(userDL.getFilename());
					// path.toFile();
					response.setContentType(userDL.getFileContentType());
					File file = new File("D://filesave//" + userDL.getFilename());
					System.out.println(userDL.getFilename());
					try {
						InputStream buffer = new BufferedInputStream(new FileInputStream(file));
						model.addAttribute("userDL", userDL);
						model.addAttribute("userDLapp", userDL.getDLapplicationNumber());
						System.err.println(userDL);
						ServletOutputStream out = response.getOutputStream();
						FileCopyUtils.copy(buffer, out);
						model.addAttribute("image", out);

						// response.flushBuffer();
						return "DL-card";

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				model.addAttribute("invalid", "still rto officer is not approved your DL");
			}
			model.addAttribute("app", "invalid DL applicatonNumber");
		}
		model.addAttribute("invalid", "invalid DL+++++++++");
		return "fileDownload";
	}

	// @GetMapping("dlcard")
	public String dlCard() {
		List<UserDL> readAll = dlService.readAll();

		for (UserDL userDL : readAll) {
			// if (userDL.getDLapplicationNumber().equals(DLapplicationNumber)) {

			if (userDL.getStatus().equalsIgnoreCase("approved")) {

			}
		}
		return "DL-card";
	}
	// }

}