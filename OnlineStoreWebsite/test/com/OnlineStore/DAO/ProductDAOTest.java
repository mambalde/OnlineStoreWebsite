package com.OnlineStore.DAO;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.OnlineStore.Entity.Category;
import com.OnlineStore.Entity.Product;

public class ProductDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static ProductDAO ProductDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ProductDAO = new ProductDAO(entityManager);
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
	public void CreateProductTest() throws IOException {
		Product product = new Product();
		Category category = new Category("shoes");
		category.setCategoryId(22);
		product.setCategory(category);
		product.setProductName("sandls");
		product.setPrice(3.50f);
		product.setDescription("a shoe for all");
		product.setSize("L");
		String imagePath = "C:\\Users\\방글\\Desktop\\productPhotos\\sandals.png";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

		product.setImage(imageBytes);

		Product createdProduct = ProductDAO.create(product);
		assertTrue(createdProduct.getProductId() > 0);

	}

	@Test
	public void UpdateProductTest() throws IOException {
		Product product = new Product();
		product.setProductId(20);
		Category category = new Category("Brands");
		category.setCategoryId(25);
		product.setCategory(category);
		product.setProductName("Jacket");
		product.setPrice(48.50f);
		product.setDescription(
				"A jean jacket, also called a denim jacket or trucker jacket, is a jacket made from denim.");
		product.setSize("L");
		String imagePath = "C:\\Users\\방글\\Desktop\\productPhotos\\denim.png";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

		product.setImage(imageBytes);

		Product updatedProduct = ProductDAO.update(product);
		assertEquals(updatedProduct.getProductName(), "Jacket");

	}

	@Test
	public void DeleteProductSuccessTest() {
		Integer productId = 2;
		ProductDAO.delete(productId);

		assertTrue(true);

	}

	@Test(expected = EntityNotFoundException.class)
	public void DeleteProductFailTest() {
		Integer productId = 3;
		ProductDAO.delete(productId);

	}

	@Test
	public void GetProductFailTest() {
		Integer productId = 2;
		Product product = ProductDAO.get(productId);

		assertNull(product);

	}

	@Test
	public void GetProductSuccessTest() {
		Integer productId = 1;
		Product product = ProductDAO.get(productId);

		assertNotNull(product);

	}

	@Test
	public void listProductTest() {
		List<Product> listProducts = ProductDAO.listAll();
		for (Product product : listProducts) {
			System.out.println(product.getProductName());
		}
		assertFalse(listProducts.isEmpty());
	}

	@Test
	public void findByNameTestNotExistent() {
		String name = "Deni";
		Product product = ProductDAO.findByName(name);
		
		assertNull(product);

	}
	
	@Test
	public void findByNameTestExistent() {
		String name = "Denim Jacket";
		Product product = ProductDAO.findByName(name);
		
		assertNotNull(product);

	}
	
	@Test
	public void countProductTest(){
		long totalProducts = ProductDAO.count();
		
		assertEquals(2, totalProducts);
	}

}
