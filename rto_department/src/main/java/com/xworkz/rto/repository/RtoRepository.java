package com.xworkz.rto.repository;

import java.util.List;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.entity.RtoEntity;

public interface RtoRepository {

	public abstract boolean onSave(RtoDTO dto);

	public abstract List<RtoEntity> readAll();

	public abstract RtoEntity login(String emailId, String password);

	public abstract RtoEntity adminLogin(String emailId, String rtoOtp);

	public abstract List<RtoEntity> searchByState(String state);

	public abstract void updateOTPbyId(RtoDTO rtoDTO);

	public abstract void updatePassword(RtoDTO rtoDTO);

	public abstract void updateLoginCount(RtoDTO dto);

	public abstract RtoEntity loginByEmail(String emailId);

}
