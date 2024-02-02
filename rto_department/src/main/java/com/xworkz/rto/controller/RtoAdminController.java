package com.xworkz.rto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.service.RtoService;
import com.xworkz.rto.util.Encrytion;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class RtoAdminController {

	@Autowired
	RtoService service;
	@Autowired
	Encrytion encrypt;

	@PostMapping("save")
	// @RequestMapping(value = "save", method =
	// {RequestMethod.GET,RequestMethod.POST})
	public String onSave(@ModelAttribute RtoDTO dto, Model model) {
		List<RtoDTO> dtos = service.readAll();
		for (RtoDTO rtoDTO : dtos) {
			if (rtoDTO.getEmailId().equalsIgnoreCase(dto.getEmailId())) {
				model.addAttribute("error", "* email is already exist");
				if (rtoDTO.getMobileNumber() == dto.getMobileNumber()) {
					model.addAttribute("error1", "* mobileNumber is already exist");
					return "SignUp";
				}
			} else {
				System.out.println("onSave method" + dto);
				Set<ConstraintViolation<RtoDTO>> save = service.validateAndCheck(dto);
				log.info("save the rto officer data");
				model.addAttribute("dto", dto);
				if (save.isEmpty()) {
					model.addAttribute("msg", "no violations occurred");
					model.addAttribute("successfully", "sucessfully registered");
					return "SignUp";
				} else {
					List<String> violMessages = new ArrayList<String>();
					for (ConstraintViolation<RtoDTO> violation : save) {
						violMessages.add(violation.getMessage());
					}
					model.addAttribute("validator", violMessages);
					return "SignUp";
				}
			}
		}
		return "success";
	}

	@GetMapping("readAll")
	public String readAll(Model model) {
		System.out.println("reading method in controller");
		List<RtoDTO> dtos = service.readAll();
		log.info("read rto officer data" + dtos);

		model.addAttribute("dto", dtos);
		return "readAll";
	}

	@GetMapping("searchByState")
	public String searchByState(@RequestParam String state, Model model) {
		List<RtoDTO> dtos = service.searchByState(state);
		RtoDTO dto = new RtoDTO();
		encrypt.decrypt(dto.getPassword());
		System.out.println(dtos);
		model.addAttribute("dto", dtos);
		return "adminProfile";
	}
}
