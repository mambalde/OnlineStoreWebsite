package com.OnlineStore.DAO;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.OnlineStore.Entity.Category;

public class CategoryDAOTest {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	private static CategoryDAO CategoryDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CategoryDAO = new CategoryDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		try {
			entityManager.close();
			entityManagerFactory.close();
	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testCreateCategory() {
		Category newCategory = new Category("Beauty");
		Category category = CategoryDAO.create(newCategory);
		assertTrue(category != null && category.getCategoryId() > 0);

	}

	@Test
	public void testUpdateCategory() {
		Category newCategory = new Category("Brands");
		newCategory.setCategoryId(6);
		Category category = CategoryDAO.update(newCategory);

		assertEquals(category.getName(), newCategory.getName());
	}

	@Test
	public void testGet() {
		Integer catId = 4;
		Category category = CategoryDAO.get(catId);
		assertNotNull(category);
	}

	@Test
	public void testDeleteObject() {
		Integer catId = 5;
		CategoryDAO.delete(catId);
		Category category = CategoryDAO.get(catId);
		assertNull(category);
	}

	@Test
	public void testListAll() {
		List<Category> listCategory = CategoryDAO.listAll();

		assertTrue(listCategory.size() > 0);
	}

	@Test
	public void testCount() {
		long totalCategory = CategoryDAO.count();
		assertEquals(1, totalCategory);

	}

}
