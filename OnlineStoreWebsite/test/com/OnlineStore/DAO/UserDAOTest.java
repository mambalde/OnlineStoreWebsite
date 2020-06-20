package com.OnlineStore.DAO;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.OnlineStore.Entity.Users;

public class UserDAOTest {
	
	private static UserDAO userDAO;

	@BeforeClass
	public static void setUpclass() {
		userDAO = new UserDAO();
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsers() {
		Users user1 = new Users();

		user1.setEmail("baldttt@java.core");
		user1.setFullname("baldeee");
		user1.setPassword("1eee");

		user1 = userDAO.create(user1);
		assertTrue(user1.getUserId() > 0);
	}

	@Test
	public void testUpdateUser() {
		Users user2 = new Users();
		user2.setEmail("bald@java.core");
		user2.setUserId(27);
		user2.setFullname("bald");
		user2.setPassword("1");
		user2 = userDAO.update(user2);
	}

	@Test
	public void testGetUsersFound() {
		Integer userId = 26;
		Users users = userDAO.get(userId);
		if (users != null) {
			System.out.println(users.getEmail());
		}

		assertNotNull(users);

	}

	@Test
	public void testGetUserNotFound() {
		Integer userId = 1;
		Users users = userDAO.get(userId);
		assertNull(users);
	}

	@Test
	public void testDeleteUser() {
		Integer id = 26;
		userDAO.delete(id);
		Users users = userDAO.get(id);
		assertNull(users);

	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistentUser() {
		Integer id = 26;
		userDAO.delete(id);
	}

	@Test
	public void tesListAll() {
		List<Users> listUsers = userDAO.listAll();
		for (Users users : listUsers) {
			System.out.println(users.getEmail());
		}
		assertTrue(listUsers.size() > 0);
	}

	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		assertEquals(3, totalUsers);
		System.out.println(totalUsers);
	}
	
	@Test
	public void checkLoginSuccess(){
		String email = "talibe@gmail.com";
		String password = "talibe";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertTrue(loginResult);
		
	}
	
	@Test
	public void checkLoginFail(){
		String email = "talibee@gmail.com";
		String password = "talibee";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertFalse(loginResult);
		
	}
	
	
	

	@Test
	public void testFindByEmail() {
		String email = "saliou@hotmail.com";
		Users user = userDAO.findByEmail(email);
		assertNotNull(user);
	}

	@AfterClass
	public static void tearDownClass() {
		try {
			userDAO.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
