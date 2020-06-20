package com.OnlineStore.Controller.Admin.Category;

import com.OnlineStore.Service.CategoryServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin/edit_category")
public class EditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCategoryServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryServices categoryServices =  new CategoryServices(request, response);
		categoryServices.editCategory();
	}

}
