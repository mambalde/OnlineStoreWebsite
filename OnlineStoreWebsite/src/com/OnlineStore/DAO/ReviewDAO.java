package com.OnlineStore.DAO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.OnlineStore.Entity.Review;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {

	@Override
	public Review create(Review review) {
		review.setReviwedTime(new Date());
		return super.create(review);
	}

	@Override
	public Review update(Review review) {
		
		return super.update(review);
	}

	@Override
	public Review get(Object reviewId) {
		
		return super.find(Review.class, reviewId) ;
	}

	@Override
	public void delete(Object reviewId) {
		super.delete(Review.class, reviewId);
	}

	@Override
	public List<Review> listAll() {
		
		return super.findWithNamedQuery("Review.listAll") ;
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("Review.countAll");
	}
	
	public Review findByCustomeAndProduct(Integer customerId, Integer productId){
		Map<String, Object> parameters = new HashMap< >();
		parameters.put("customerId", customerId);
		parameters.put("productId", productId);
		
		List<Review> result = super.findWithNamedQuery("Review.findByCustomerAndProduct", parameters);
		
		if(!result.isEmpty()){
			return result.get(0);
		}
		return null;
	}

}
