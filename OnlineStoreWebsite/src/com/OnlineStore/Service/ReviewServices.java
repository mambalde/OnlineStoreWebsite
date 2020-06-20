package com.OnlineStore.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.OnlineStore.Service.CommonUtility;

import com.OnlineStore.DAO.ReviewDAO;
import com.OnlineStore.Entity.Product;
import com.OnlineStore.Entity.Review;

public class ReviewServices extends CommonUtility {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ReviewDAO reviewDAO;
	public ReviewServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		reviewDAO = new ReviewDAO();
	}
	
	public void listAllReviews() throws ServletException, IOException {
		listAllReviews(null);
	}
	
	public void listAllReviews(String message) throws ServletException, IOException {
		
		List<Review> listOfReviews = reviewDAO.listAll();
		
		request.setAttribute("listOfReviews", listOfReviews);
		
		if(message != null){
			
			request.setAttribute("message", message);
		}
		
		String listPage = "review_list.jsp";
		RequestDispatcher dispatcher  = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void editReview() throws ServletException, IOException {
		
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		
		Review review = reviewDAO.get(reviewId);
		
		if (review != null) {		
			request.setAttribute("review", review);		
			forwardToPage("review_form.jsp", request, response);
		}else {
			String message = "Could not find review with ID " + reviewId;
			showMessageBackend(message, request, response);
		}
			
	}

	public void updateReview() throws ServletException, IOException {
		
		Integer reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		
		Review review = reviewDAO.get(reviewId);
		review.setComment(comment);
		review.setHeadline(headline);
		
		reviewDAO.update(review);
		
		String message = "The review has been successfully updated!";
		listAllReviews(message);
	}

	public void deleteReview() throws ServletException, IOException {
		
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		Review review = reviewDAO.get(reviewId);
		
		if (review != null) {
			reviewDAO.delete(reviewId);
			String message = "The review has been deleted successfully.";
			listAllReviews(message);
		} else {
			String message = "Could you find review with ID " + reviewId
					+ ", or it might have been deleted by another admin";
			showMessageBackend(message, request, response);
		}		
	}
	
	
}
