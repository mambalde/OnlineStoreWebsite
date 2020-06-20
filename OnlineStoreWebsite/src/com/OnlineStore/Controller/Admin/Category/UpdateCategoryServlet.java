package com.OnlineStore.Controller.Admin.Category;

import com.OnlineStore.Service.CategoryServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin/update_category")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCategoryServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoryServices categoryServices = new CategoryServices(request, response);
		categoryServices.updateCategory();
	}

}
