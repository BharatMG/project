package com.xworkz.rto.service;

import java.util.List;

import com.xworkz.rto.dto.UserDL;

public interface RtoDLService {

	public abstract boolean dlSave(UserDL userDL);

	public abstract List<UserDL> searchByUserDL(String state);

	public abstract boolean updateDLStatus(String DLapplicationNumber);

	public abstract UserDL searchByDLAplication(String dlApplicationNumber);

	public abstract boolean updateId(UserDL dl);

	public abstract boolean updateDLId(int id);

	public abstract List<UserDL> readAll();
}
