package com.OnlineStore.Category;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.OnlineStore.Entity.Users;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Users user1 = new Users();
		user1.setFullname("balde saliou");
		user1.setEmail("mambalde@gmail.com");
		user1.setPassword("1234");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println(" user added susscessfully"); 
	}

}
