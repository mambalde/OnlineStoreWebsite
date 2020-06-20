package com.OnlineStore.Controller.Admin.Review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.Service.ReviewServices;

@WebServlet("/Admin/update_review")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateReviewServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ReviewServices reviewServices = new ReviewServices(request, response);
		reviewServices.updateReview();
	}

}
