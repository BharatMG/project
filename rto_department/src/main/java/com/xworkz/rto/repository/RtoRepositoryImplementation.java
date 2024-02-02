package com.xworkz.rto.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.rto.dto.RtoDTO;
import com.xworkz.rto.entity.RtoEntity;
import com.xworkz.rto.util.Encrytion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RtoRepositoryImplementation implements RtoRepository {

	@Autowired
	EntityManagerFactory factory;

	@Autowired
	private Encrytion encrypt1;

	public RtoRepositoryImplementation() {
		System.out.println("RtoRepositoryImplementation constructor");
	}

	@Override
	public RtoEntity login(String emailId, String password) {
		EntityManager manager = factory.createEntityManager();
		log.info("login method by rto officer repo");
		System.out.println(("login method by rto officer repo"));
		RtoEntity entity = new RtoEntity();
		try {
			Query query = manager.createNamedQuery("login");
			query.setParameter("email", emailId);
			query.setParameter("password", password);
			System.out.println("password in repo" + query.getSingleResult());
			// entity.setPassword(encrypt1.decrypt(password));
			return (RtoEntity) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("invalid email & password");
			return entity;

		}

	}

	@Override
	public boolean onSave(RtoDTO dto) {
		System.out.println("onsave method in repository");
		EntityManager manager = factory.createEntityManager();
		log.info("save method by rto officer repo");
		System.out.println(dto);
		RtoEntity entity = new RtoEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setRegistereDateTime(LocalDateTime.now());
		entity.setPassword(encrypt1.encrypt(dto.getPassword()));
		entity.setConfirmPassword(encrypt1.encrypt(dto.getConfirmPassword()));
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}

	@Override
	public List<RtoEntity> readAll() {
		System.out.println("readAll method in repository");
		EntityManager manager = factory.createEntityManager();
		log.info("readAll method by rto officer repo");
		Query query = manager.createNamedQuery("readAll");
//		System.err.println((List<RtoEntity>) query.getResultList());
		return (List<RtoEntity>) query.getResultList();
	}

	@Override
	public RtoEntity adminLogin(String emailId, String rtoOtp) {
		EntityManager manager = factory.createEntityManager();
		log.info("Adminlogin method by rto officer repo");
		RtoEntity entity = new RtoEntity();
		Query query = manager.createNamedQuery("OTPlogin");
		query.setParameter("email", emailId);
		query.setParameter("rtoOtp", rtoOtp);
		// System.out.println("correct+\u001B[31m");
		try {
			return (RtoEntity) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("admin repository failed to login+\\u001B[31m");
			return null;
		}
	}

	@Override
	public List<RtoEntity> searchByState(String state) {
		EntityManager manager = factory.createEntityManager();
		log.info("searchByState method by rto officer repo");
		RtoEntity entity = new RtoEntity();

		Query query = manager.createNamedQuery("findByState");
		query.setParameter("state", state);
		encrypt1.decrypt(entity.getPassword());
		List<RtoEntity> entities = query.getResultList();
		return entities;
	}

	@Override
	public void updateOTPbyId(RtoDTO rtoDTO) {
		EntityManager manager = factory.createEntityManager();
		log.info("updateOTPbyId method by rto officer ");
		RtoEntity entity = new RtoEntity();
		BeanUtils.copyProperties(rtoDTO, entity);
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void updatePassword(RtoDTO rtoDTO) {
		EntityManager manager = factory.createEntityManager();
		log.info("updatePassword method by rto officer");
		RtoEntity entity = new RtoEntity();
		BeanUtils.copyProperties(rtoDTO, entity);
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();

	}

	@Override
	public void updateLoginCount(RtoDTO dto) {
		EntityManager manager = factory.createEntityManager();
		RtoEntity entity = new RtoEntity();
		BeanUtils.copyProperties(dto, entity);
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public RtoEntity loginByEmail(String emailId) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("readByEmail");
		query.setParameter("email", emailId);
		return (RtoEntity) query.getSingleResult();
	}
}