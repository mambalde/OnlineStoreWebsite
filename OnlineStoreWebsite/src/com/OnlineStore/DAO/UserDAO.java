package com.OnlineStore.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;


import com.OnlineStore.Entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public Users create(Users user) {
		String encryptedPassword = HashGenerator.generateMD5(user.getPassword());
		user.setPassword(encryptedPassword);
		return super.create(user);
	}

	@Override
	public Users update(Users user) {

		return super.update(user);
	}

	@Override
	public Users get(Object userId) {
		return super.find(Users.class, userId);
	}

	public Users findByEmail(String email) {
		List<Users> listUsers = super.findWithNamedQuery("Users.findByEmail", "email", email);

		if (listUsers != null && listUsers.size() == 1) {
			return listUsers.get(0);
		}
		return null;
	}

	public boolean checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<>();
		String encryptedPassword = HashGenerator.generateMD5(password);
		parameters.put("email", email);
		parameters.put("password", encryptedPassword);

		List<Users> listUsers = super.findWithNamedQuery("Users.checkLogin", parameters);
		
		if(listUsers.size()==1){
			return true;
		}
		return false;
	}

	@Override
	public void delete(Object userId) {
		super.delete(Users.class, userId);

	}

	@Override
	public List<Users> listAll() {
		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {

		return super.countWithNamedQuery("Users.countAll");
	}

}
