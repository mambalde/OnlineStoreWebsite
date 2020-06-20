package com.OnlineStore.DAO;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.OnlineStore.Entity.Customer;

public class CustomerDAOTest {
	private static CustomerDAO customerDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDAO = new CustomerDAO();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		customerDAO.close();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();

		customer.setFullname("BALDE MAMADOU SALIOU");
		customer.setAddress("suwon");
		customer.setCity("seoul");
		customer.setCountry("Guinea");
		customer.setEmail("mambald@gmail.com");
		customer.setPassword("balde");
		customer.setPhone("01041931663");
		customer.setZipcode("1254");

		Customer createdCustomer = customerDAO.create(customer);

		assertTrue(createdCustomer.getCustomerId() > 0);
	}

	@Test
	public void testGet() {
		Integer customerId = 1;
		Customer customer = customerDAO.get(customerId);
		assertNotNull(customer);
	}

	@Test
	public void testDeleteObject() {

		Integer id = 1;
		customerDAO.delete(id);
		Customer customer = customerDAO.get(id);

		assertNull(customer);

	}

	@Test
	public void testListCustomer() {

		List<Customer> listOfCustomers = customerDAO.listAll();

		assertTrue(listOfCustomers.size() == 2);

	}
	
	@Test
	public void countCustomerTest(){
		long totalCustomers = customerDAO.count();
		
		assertEquals(2, totalCustomers);
	}
	
	@Test
	public void testFindByemail(){
		
		String email = "mambalde@gmail.com";
		Customer customer = customerDAO.findByEmail(email);
		
		assertNotNull(customer);
	}
	
	@Test
	public void checkloginSuccess(){
		
		String email = "mambalde@gmail.com";
		String password = "balde";
		Customer customer = customerDAO.checkLogin(email, password);
		
		assertNotNull(customer);
	}
	@Test
	public void checkloginFail(){
		
		String email = "mambalde@gmail.com";
		String password = "baldee";
		Customer customer = customerDAO.checkLogin(email, password);
		
		assertNull(customer);
	}

}
