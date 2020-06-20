package com.OnlineStore.Entity;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ProductRatingTest {

	@Test
	public void test() {
		Product product = new Product();
		Set<Review> reviews = new HashSet<>();
		Review review = new Review();
		review.setRating(5);
		reviews.add(review);
		product.setReviews(reviews);
		
		float averageRating = product.getAverageRating();
		
		assertEquals(5.0, averageRating,0.0);
	}

	@Test
	public void testRatingStars(){
		float averageRating = 0.0f;
		Product product = new Product();
		String actual = product.getRatingString(averageRating);
		String expected = "off,off,off,off,off";
		assertEquals(expected, actual);
	}
	@Test
	public void testRatingStars2(){
		float averageRating = 5.0f;
		Product product = new Product();
		String actual = product.getRatingString(averageRating);
		String expected = "on,on,on,on,on";
		assertEquals(expected, actual);
	}
	@Test
	public void testRatingStars3(){
		float averageRating = 3.0f;
		Product product = new Product();
		String actual = product.getRatingString(averageRating);
		String expected = "on,on,on,off,off";
		assertEquals(expected, actual);
	}
	@Test
	public void testRatingStars4(){
		float averageRating = 4.5f;
		Product product = new Product();
		String actual = product.getRatingString(averageRating);
		String expected = "on,on,on,on,half";
		assertEquals(expected, actual);
	}
}
