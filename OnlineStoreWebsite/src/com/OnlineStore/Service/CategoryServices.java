package com.OnlineStore.Service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.DAO.CategoryDAO;
import com.OnlineStore.DAO.UserDAO;
import com.OnlineStore.Entity.Category;

public class CategoryServices {
	private CategoryDAO categoryDAO;

	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;

		categoryDAO = new CategoryDAO(entityManager);

	}

	public void listCategory() throws ServletException, IOException {
		List<Category> listcategory = categoryDAO.listAll();

		request.setAttribute("listcategory", listcategory);
		String listPage = "category_list.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);

	}

}
