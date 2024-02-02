package com.xworkz.rto.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.entity.RtoEntity;
import com.xworkz.rto.repository.RtoRepository;
import com.xworkz.rto.util.Encrytion;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RtoServiceImplementation implements RtoService {

	public RtoServiceImplementation() {
		log.info("RtoServiceImplementation constructor");
	}

	@Autowired
	RtoRepository repository;

	@Autowired
	private Encrytion encrypt1;

	/*
	 * @Autowired PasswordEncoder passwordEncoder;
	 */

	/*
	 * @Autowired private Encrytion encrypt;
	 */
	@Override
	public Set<ConstraintViolation<RtoDTO>> validateAndCheck(RtoDTO dto) {
		log.info("onSave method in service");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<RtoDTO>> violations = validator.validate(dto);
		if (violations.isEmpty()) {
			// if (dto != null) {
			if (dto.getPassword().equals(dto.getConfirmPassword())) {
				// dto.setPassword(encrypt1.encrypt(password));
				dto.setRtoOtp("12345");
				repository.onSave(dto);
			}
			// }
			return violations;
		} else {
			System.out.println("Violations Present");
			return violations;
		}
	}

	@Override
	public List<RtoDTO> readAll() {
		log.info("readAll method in service");
		List<RtoEntity> entities = repository.readAll();
		List<RtoDTO> dtos = new ArrayList<RtoDTO>();
		for (RtoEntity rtoEntity : entities) {
			RtoDTO dto = new RtoDTO();
			// System.err.println("Before RtoEntity " + rtoEntity);

			BeanUtils.copyProperties(rtoEntity, dto);
			dto.setPassword(encrypt1.decrypt(rtoEntity.getPassword()));
			// encrypt1.decrypt(dto.getPassword());
			dtos.add(dto);
		}
		return dtos;

	}

	@Override
	public RtoDTO login(String emailId, String password) {
		log.info("login method for rto officer");
		RtoEntity entity = repository.login(emailId, password);
		RtoDTO dto = new RtoDTO();
		// entity.setPassword(encrypt1.decrypt(password));
		// encrypt1.decrypt(entity.getPassword());
		System.out.println(entity);
		BeanUtils.copyProperties(entity, dto);
		// dto.setPassword(encrypt1.decrypt(entity.getPassword()));
		// entity.setPassword(encrypt1.decrypt(dto.getPassword()));
		System.out.println("++++++++++++++++++++++++ service++++++++++");
		// System.err.println(encrypt1.decrypt(dto.getPassword()).equalsIgnoreCase(password));
		if (dto.getEmailId().equalsIgnoreCase(emailId) && dto.getPassword().equalsIgnoreCase(password)) {
			return dto;
		} else {
			return null;
		}
	}

	@Override
	public RtoDTO adminLogin(String emailId, String rtoOtp) {
		log.info("adminLogin method for rto officer");
		RtoEntity entity1 = repository.adminLogin(emailId, rtoOtp);
		System.out.println(entity1);
		if (entity1 != null) {
			RtoDTO dto = new RtoDTO();
			BeanUtils.copyProperties(entity1, dto);
			if (dto.getEmailId().equalsIgnoreCase(emailId) && dto.getRtoOtp().equalsIgnoreCase(rtoOtp)) {
				// dto.setLoginCount(0);
				dto.setAccountActiveOrDeActive("Active");
				System.out.println("account is active");
				return dto;
			} else {
				dto.setAccountActiveOrDeActive("InActive");
				log.info("Invalid email or password");
				System.out.println("Invalid email or password");
				return null;
			}
		} else {
			// entity1.setAccountActiveOrDeActive("InActive");
//			dto.setAccountActiveOrDeActive("InActive");
			log.info("entity is not null");
			System.err.println("entity is not null");
			// return null;
		}
		return null;
	}

	@Override
	public List<RtoDTO> searchByState(String state) {
		log.info("searchByState method for ");
		List<RtoDTO> dtos = new ArrayList<RtoDTO>();
		List<RtoEntity> entities = repository.searchByState(state);
		for (RtoEntity rtoEntity : entities) {
			RtoDTO dto = new RtoDTO();
			BeanUtils.copyProperties(rtoEntity, dto);
			dto.setPassword(encrypt1.decrypt(rtoEntity.getPassword()));
			dtos.add(dto);

		}
		return dtos;

	}

	@Override
	public void updateOTPbyId(RtoDTO rtoDTO, String otp) {
		log.info("updateOTPbyId method in service");
		rtoDTO.setRtoOtp(encrypt1.encrypt(otp));
		rtoDTO.setOtpRequestTime(LocalDateTime.now());
		repository.updateOTPbyId(rtoDTO);
	}

	@Override
	public void updatePassword(RtoDTO rtoDTO, String password, String confirmPassword) {
		log.info(" rto officer updatePassword  in service method");
		rtoDTO.setPassword(encrypt1.encrypt(password));
		rtoDTO.setConfirmPassword(encrypt1.encrypt(confirmPassword));
		repository.updatePassword(rtoDTO);

	}

	@Override
	public void updateLoginCount(RtoDTO dto) {
		repository.updateLoginCount(dto);

	}

	@Override
	public RtoDTO loginByEmail(String emailId) {
		RtoEntity entity = repository.loginByEmail(emailId);
		RtoDTO dto = new RtoDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/*
	 * @Override public void updatePassword(RtoDTO rtoDTO, String password, String
	 * confirmPassword) { rtoDTO.setPassword(passwordEncoder.encode(password));
	 * rtoDTO.setConfirmPassword(passwordEncoder.encode(confirmPassword));
	 * repository.updatePassword(rtoDTO);
	 * 
	 * }
	 */
}