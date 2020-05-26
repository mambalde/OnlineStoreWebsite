package com.OnlineStore.DAO;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.OnlineStore.Entity.Users;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;

	@BeforeClass
	public static void setUpclass() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsers() {
		Users user1 = new Users();

		user1 = userDAO.create(user1);
	}

	@Test
	public void testUpdateUser() {
		Users user2 = new Users();
		user2.setEmail("bald@java.core");
		user2.setUserId(26);
		user2.setFullname("balde");
		user2.setPassword("1");
		user2 = userDAO.update(user2);
		String expected = "bald@java.core";
		String actual = user2.getPassword();
	}

	@AfterClass
	public static void tearDownClass() {
		try {
			entityManager.close();
			entityManagerFactory.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
