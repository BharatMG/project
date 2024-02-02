package com.xworkz.rto.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.rto.dto.UserDL;
import com.xworkz.rto.entity.UserDLEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RtoDLRepositoryImplementation implements RtoDLRepository {

	@Autowired
	EntityManagerFactory factory;

	@Override
	public boolean saveDL(UserDL userDL) {
		System.err.println("repo method in save");
		EntityManager manager = factory.createEntityManager();
		UserDLEntity userDLEntity = new UserDLEntity();
		BeanUtils.copyProperties(userDL, userDLEntity);
		userDLEntity.setUserRegistereDateTime(LocalDateTime.now());
		userDLEntity.setStatus("pending");
		manager.getTransaction().begin();
		manager.persist(userDLEntity);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}

	@Override
	public List<UserDLEntity> dlEntities(String state) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("DLByState");
		query.setParameter("dlstate", state);
		List<UserDLEntity> dlEntities = query.getResultList();
		return dlEntities;
	}

	@Override
	public List<UserDLEntity> searchByDLState(String state) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("DLByState");
		query.setParameter("dlstate", state);
		List<UserDLEntity> dlEntities = query.getResultList();
		return dlEntities;
	}

	@Override
	public boolean updateDLStatus(String DLapplicationNumber) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("updateDLStatus");
		query.setParameter("DLappl", DLapplicationNumber);
		manager.getTransaction().begin();
		int update = query.executeUpdate();
		manager.getTransaction().commit();
		return update > 0;
	}

	@Override
	public UserDLEntity searchByDLAplication(String dlApplicationNumber) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("searchByApplication");
		query.setParameter("DLapplicationNumber", dlApplicationNumber);
		UserDLEntity dlEntities = (UserDLEntity) query.getSingleResult();
		return dlEntities;
	}

	@Override
	public boolean updateById(UserDLEntity entity) {
		EntityManager manager = factory.createEntityManager();
//		UserEntity entity = manager.find(UserEntity.class, id);
		// log.info("updateById method in rtoRepo user ");
		if (entity != null) {
			// entity.setStatus("approved");
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
			manager.close();
			return true;
		} else {
			System.out.println("invalid id");
			return false;
		}

		// return false;
	}

	public boolean updateByDLId(int id) {
		EntityManager manager = factory.createEntityManager();
		UserDLEntity entity = manager.find(UserDLEntity.class, id);
		log.info("updateById method in rtoRepo user ");
		if (entity != null) {
			entity.setStatus("approved");
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
			manager.close();
			return true;
		} else {
			System.out.println("invalid id");
			return false;
		}
	}

	@Override
	public List<UserDLEntity> readAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("searchAll");
		List<UserDLEntity> entities = query.getResultList();
		return entities;
	}
}