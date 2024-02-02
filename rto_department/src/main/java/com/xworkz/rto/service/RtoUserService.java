package com.xworkz.rto.service;

import java.util.List;

import com.xworkz.rto.dto.UserDTO;

public interface RtoUserService {

	public abstract boolean checkSave(UserDTO userDTO);

	public abstract List<UserDTO> readUser();

	public abstract List<UserDTO> searchByUserState(String state);

	public abstract UserDTO userLogin(String apporcontact, String dob);

	public abstract boolean updateId(int id);

	public abstract boolean updateStatus(String applicationNumber);

	public abstract UserDTO checkApplicationNumber(String applicationNumber);

}
