package com.xworkz.rto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rto.dto.UserDL;
import com.xworkz.rto.entity.UserDLEntity;
import com.xworkz.rto.repository.RtoDLRepository;

@Service
public class RtoDLServiceImplementation implements RtoDLService {

	@Autowired
	RtoDLRepository rtoDLRepo;

	@Override
	public boolean dlSave(UserDL userDL) {
		System.out.println("service method in dlSave");
		// if (userDL != null) {
		int randomNumber = (int) ((Math.random() * 9000) + 100);
		String otp = String.valueOf(randomNumber);
		String code = null;

		if (userDL.getState().equals("Karnataka")) {
			code = "KA2024" + otp;
		}
		if (userDL.getState().equals("Kerala")) {
			code = "KL2024" + otp;
		}
		if (userDL.getState().equals("Maharashtra")) {
			code = "MH2024" + otp;
		}
		if (userDL.getState().equals("Odisha")) {
			code = "MH2024" + otp;
		}
		userDL.setDLapplicationNumber(code);

		rtoDLRepo.saveDL(userDL);
		// }
		return true;
	}

	@Override
	public List<UserDL> searchByUserDL(String state) {
		List<UserDLEntity> eDls = rtoDLRepo.searchByDLState(state);
		List<UserDL> userDLs = new ArrayList<UserDL>();
		for (UserDLEntity userDLEntity : eDls) {
			UserDL userDL = new UserDL();
			BeanUtils.copyProperties(userDLEntity, userDL);
			userDLs.add(userDL);
		}
		return userDLs;
	}

	@Override
	public boolean updateDLStatus(String DLapplicationNumber) {
		rtoDLRepo.updateDLStatus(DLapplicationNumber);
		return true;
	}

	@Override
	public UserDL searchByDLAplication(String dlApplicationNumber) {
		UserDLEntity entity = rtoDLRepo.searchByDLAplication(dlApplicationNumber);

		UserDL dl = new UserDL();
		BeanUtils.copyProperties(entity, dl);
		return dl;
	}

	@Override
	public boolean updateId(UserDL dl) {

		UserDLEntity entity = new UserDLEntity();
		BeanUtils.copyProperties(dl, entity);
		rtoDLRepo.updateById(entity);
		return false;
	}

	@Override
	public boolean updateDLId(int id) {
		return rtoDLRepo.updateByDLId(id);
	}

	@Override
	public List<UserDL> readAll() {
		List<UserDLEntity> entities = rtoDLRepo.readAll();
		List<UserDL> userDL = new ArrayList<UserDL>();
		for (UserDLEntity userDLEntity : entities) {
			UserDL user1DL = new UserDL();
			BeanUtils.copyProperties(userDLEntity, user1DL);
			userDL.add(user1DL);
		}
		return userDL;
	}
}
