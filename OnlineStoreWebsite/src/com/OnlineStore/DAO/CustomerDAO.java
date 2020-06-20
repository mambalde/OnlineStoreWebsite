package com.OnlineStore.DAO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.OnlineStore.Entity.Customer;
import com.OnlineStore.Entity.Users;

public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer> {

	@Override
	public Customer create(Customer customer) {
		customer.setRegisteredDate(new Date());
		return super.create(customer);
	}

	@Override
	public Customer update(Customer customer) {

		return super.update(customer);
	}

	@Override
	public Customer get(Object id) {

		return super.find(Customer.class, id);
	}

	@Override
	public void delete(Object id) {

		super.delete(Customer.class, id);

	}

	@Override
	public List<Customer> listAll() {

		return super.findWithNamedQuery("Customer.findAll");
	}

	public Customer findByEmail(String email) {

		List<Customer> listCustomer = super.findWithNamedQuery("Customer.findByEmail", "email", email);

		if (listCustomer != null && listCustomer.size() == 1) {
			return listCustomer.get(0);
		}

		return null;
	}

	public Customer checkLogin(String email, String password) {

		Map<String, Object> parameters = new HashMap<>();
		
		String encryptedPassword = HashGenerator.generateMD5(password);
		
		parameters.put("email", email);
		parameters.put("password", encryptedPassword);

		List<Customer> result = super.findWithNamedQuery("Customer.checkLogin", parameters);

		if (!result.isEmpty()) {
			
			return result.get(0);
		}
		return null;
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Customer.countAll");
	}

}
