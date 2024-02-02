package com.xworkz.rto.repository;

import java.util.List;

import com.xworkz.rto.dto.UserDL;
import com.xworkz.rto.entity.UserDLEntity;

public interface RtoDLRepository {

	public abstract boolean saveDL(UserDL userDL);

	public abstract List<UserDLEntity> dlEntities(String state);

	public abstract List<UserDLEntity> searchByDLState(String state);

	public abstract boolean updateDLStatus(String DLapplicationNumber);

	UserDLEntity searchByDLAplication(String dlApplicationNumber);

	public abstract boolean updateById(UserDLEntity dl);

	public boolean updateByDLId(int id);

	public abstract List<UserDLEntity> readAll();

}
