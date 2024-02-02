package com.xworkz.rto.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.rto.dto.RtoDTO;

public interface RtoService {

	public abstract Set<ConstraintViolation<RtoDTO>> validateAndCheck(RtoDTO dto);

	public abstract List<RtoDTO> readAll();

	public abstract RtoDTO login(String emailId, String password);

	public abstract RtoDTO adminLogin(String emailId, String rtoOtp);

	public abstract List<RtoDTO> searchByState(String state);

	public abstract void updateOTPbyId(RtoDTO rtoDTO, String otp);

	public abstract void updatePassword(RtoDTO rtoDTO, String password, String confirmPassword);

	public abstract void updateLoginCount(RtoDTO dto);

	public RtoDTO loginByEmail(String emailId);
}
