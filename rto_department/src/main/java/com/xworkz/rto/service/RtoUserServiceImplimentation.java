package com.xworkz.rto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.entity.UserEntity;
import com.xworkz.rto.repository.RtoUserRepository;

@Service
public class RtoUserServiceImplimentation implements RtoUserService {

	@Autowired
	RtoUserRepository userrepo;

	@Override
	public boolean checkSave(UserDTO userDTO) {
		if (userDTO != null) {
			int randomNumber = (int) ((Math.random() * 900) + 100);
			String otp = String.valueOf(randomNumber);
			String code = null;
			if (userDTO.getState().equals("Karnataka")) {
				code = "KA2023LLR" + otp;
			}
			if (userDTO.getState().equals("Kerala")) {
				code = "KL2023LLR" + otp;
			}
			if (userDTO.getState().equals("Maharashtra")) {
				code = "MH2023LLR" + otp;
			}
			if (userDTO.getState().equals("Odisha")) {
				code = "MH2023LLR" + otp;
			}
			userDTO.setApplicationNumber(code);
			boolean check = userrepo.userSave(userDTO);
			return true;
		}
		System.out.println("user data is null");
		return false;
	}

	@Override
	public List<UserDTO> readUser() {
		List<UserEntity> entities = userrepo.readAll();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (UserEntity userEntity : entities) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(userEntity, userDTO);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

	@Override
	public List<UserDTO> searchByUserState(String state) {
		List<UserEntity> entities = userrepo.searchByUserState(state);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (UserEntity userEntity : entities) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(userEntity, userDTO);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

	@Override
	public UserDTO userLogin(String apporcontact, String dob) {
		UserEntity userEntity = userrepo.userLogin(apporcontact, dob);
		if (userEntity != null) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(userEntity, userDTO);
			return userDTO;
		} else {
			return null;
		}
	}

	@Override
	public boolean updateStatus(String applicationNumber) {
		userrepo.updateStatus(applicationNumber);
		return true;
	}

	@Override
	public boolean updateId(int id) {
		boolean update = userrepo.updateById(id);
		return update;
	}

	@Override
	public UserDTO checkApplicationNumber(String applicationNumber) {
		UserEntity entities = userrepo.checkApplicationNumber(applicationNumber);
		// List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		// for (UserEntity userEntity : entities) {
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(entities, userDTO);
		// userDTOs.add(userDTO);
		// }
		return userDTO;

	}
}
