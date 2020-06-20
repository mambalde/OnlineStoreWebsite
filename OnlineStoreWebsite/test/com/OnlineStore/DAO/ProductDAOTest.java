package com.OnlineStore.DAO;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.OnlineStore.Entity.Category;
import com.OnlineStore.Entity.Product;

public class ProductDAOTest {
	
	private static ProductDAO ProductDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		ProductDAO = new ProductDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		try {
			ProductDAO.close();

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
	public void countProductTest() {
		long totalProducts = ProductDAO.count();

		assertEquals(2, totalProducts);
	}

	@Test
	public void listByCategoryTest() {
		int categoryId = 20;
		List<Product> products = ProductDAO.listByCategory(categoryId);

		assertTrue(products.size() > 0);
	}

	@Test
	public void searchProductTest() {
		
		String keyword = "sandal";
		List<Product> listResult= ProductDAO.search(keyword);
		
		for(Product product :listResult){
			System.out.println(product.getProductName());
		}
		
		assertEquals(3,listResult.size());
		
		
	}
	
	@Test
    public void searchProductByDescriptionTest() {
		
		String keyword = "Lorem";
		List<Product> listResult= ProductDAO.search(keyword);
		
		for(Product product :listResult){
			System.out.println(product.getProductName());
		}
		
		assertEquals(6,listResult.size());
		
		
	}

	@Test
	public void listNewProductsTest() {
		List<Product> listNewProducts = ProductDAO.listNewProducts();

		assertEquals(4, listNewProducts.size());
	}
	
	@Test
	public void countByCategoryTest() {
		int categoryId = 20;
		long  resultList = ProductDAO.countByCategory(categoryId);
		assertTrue(resultList==1);
	}

}
