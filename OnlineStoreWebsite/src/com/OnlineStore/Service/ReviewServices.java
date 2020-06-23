package com.OnlineStore.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OnlineStore.Service.CommonUtility;
import com.OnlineStore.DAO.ProductDAO;
import com.OnlineStore.DAO.ReviewDAO;
import com.OnlineStore.Entity.Customer;
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

		if (message != null) {

			request.setAttribute("message", message);
		}

		String listPage = "review_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void editReview() throws ServletException, IOException {

		Integer reviewId = Integer.parseInt(request.getParameter("id"));

		Review review = reviewDAO.get(reviewId);

		if (review != null) {
			request.setAttribute("review", review);
			forwardToPage("review_form.jsp", request, response);
		} else {
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

	public void showReviewForm() throws ServletException, IOException {

		Integer productId = Integer.parseInt(request.getParameter("product_id"));

		ProductDAO productDAO = new ProductDAO();

		Product product = productDAO.get(productId);

		HttpSession session = request.getSession();
		session.setAttribute("product", product);

		Customer customer = (Customer) session.getAttribute("loggedCustomer");

		Review existReview = reviewDAO.findByCustomeAndProduct(customer.getCustomerId(), productId);
		String targetPage = "FrontEnd/review_form.jsp";
		if (existReview != null) {

			request.setAttribute("review", existReview);
			targetPage = "FrontEnd/review_info.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(targetPage);
		dispatcher.forward(request, response);
	}

	public void submitReview() throws ServletException, IOException {

		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Integer rating = Integer.parseInt(request.getParameter("rating"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");

		Review newReview = new Review();

		newReview.setHeadline(headline);
		newReview.setRating(rating);
		newReview.setComment(comment);

		Product product = new Product();
		product.setProductId(productId);

		newReview.setProduct(product);

		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");

		newReview.setCustomer(customer);

		reviewDAO.create(newReview);

		String messagePage = "FrontEnd/review_done.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);

	}

}
