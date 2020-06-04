package com.OnlineStore.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.type.descriptor.java.PrimitiveByteArrayTypeDescriptor;

import com.OnlineStore.DAO.UserDAO;
import com.OnlineStore.Entity.Users;

public class UserServices {
	private UserDAO userDAO;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public UserServices() {

		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);

	}

	public List<Users> listUsers() {
		List<Users> listUsers = userDAO.listAll();
		return listUsers;
	}
}
