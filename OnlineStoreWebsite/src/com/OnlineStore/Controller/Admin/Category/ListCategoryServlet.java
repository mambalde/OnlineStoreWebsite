package com.OnlineStore.Controller.Admin.Category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.Service.CategoryServices;

@WebServlet("/Admin/list_category")
public class ListCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryServices categoryServices = new CategoryServices(request, response);
		categoryServices.listCategory();
		
	}

}
