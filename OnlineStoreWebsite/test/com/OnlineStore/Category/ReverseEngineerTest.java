package com.OnlineStore.Category;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.OnlineStore.Entity.Category;
import com.OnlineStore.Entity.Users;

public class ReverseEngineerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Category category = new Category("DENIM JACKET PANTS");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(category);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println(" CATEGORY ADDED SUCCESSFULLY"); 
	}

}
