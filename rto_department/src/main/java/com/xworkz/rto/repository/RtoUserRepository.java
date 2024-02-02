package com.xworkz.rto.repository;

import java.util.List;

import com.xworkz.rto.dto.UserDTO;
import com.xworkz.rto.entity.UserEntity;

public interface RtoUserRepository {

	public abstract boolean userSave(UserDTO userDTO);

	public abstract List<UserEntity> readAll();

	public abstract List<UserEntity> searchByUserState(String state);

	public abstract UserEntity userLogin(String apporcontact, String dob);

	public abstract boolean updateStatus(String applicationNumber);

	public abstract boolean updateById(int id);

	public abstract UserEntity checkApplicationNumber(String applicationNumber);

}
