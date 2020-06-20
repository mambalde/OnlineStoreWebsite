package com.OnlineStore.DAO;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.OnlineStore.Entity.Customer;
import com.OnlineStore.Entity.Product;
import com.OnlineStore.Entity.Review;

public class ReviewDAOTest {
	private static  ReviewDAO reviewDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDAO = new ReviewDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDAO.close();
	}

	@Test
	public void testCreateReview() {
		
		Review review = new Review();
		Product product = new Product();
		product.setProductId(19);
		Customer customer = new Customer();
		customer.setCustomerId(9);
		review.setProduct(product);
		review.setCustomer(customer);
		
		review.setHeadline("nice product");
		review.setRating(5);
		review.setComment("i love this product");
		
		Review savedreview = reviewDAO.create(review);
		
		assertTrue(savedreview.getReviewId()>0);
		
	}

	@Test
	public void testGet() {
		Integer reviewId = 1;
		Review review = reviewDAO.get(reviewId);
		
		assertNotNull(review);
	}
	
	@Test
	public void updateReview() {
		Integer reviewId = 1;
		Review review = reviewDAO.get(reviewId);
		
		review.setHeadline("amazing product");
		
		Review updatedReview = reviewDAO.update(review);
		
		assertEquals(review.getHeadline(), updatedReview.getHeadline());
	}

	@Test
	public void testListAll() {
		List< Review> listReview = reviewDAO.listAll();
		for(Review review : listReview) {
			System.out.println(review.getComment() + review.getHeadline() + review.getCustomer() + review.getProduct());
		}
		assertTrue(listReview.size()>0);
	}

	@Test
	public void testCount() {
		long totalReviews = reviewDAO.count();
		assertTrue(totalReviews >0);
	}
	
	@Test
	public void testDeleteReview() {
		int reviewId = 1;
		reviewDAO.delete(reviewId);
		
		Review review = reviewDAO.get(reviewId);
		assertNull(review );
	}

}
