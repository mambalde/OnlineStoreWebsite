package com.OnlineStore.Controller.Admin.Category;

import com.OnlineStore.Controller.BaseServlet;
import com.OnlineStore.Service.CategoryServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin/create_category")
public class CreateCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public CreateCategoryServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
		categoryServices.CreateCategory();
	}

}
