package com.OnlineStore.Service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.DAO.CategoryDAO;
import com.OnlineStore.DAO.ProductDAO;
import com.OnlineStore.Entity.Category;
import com.OnlineStore.Entity.Product;

public class ProductServices {
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CategoryDAO categoryDAO;
	private ProductDAO productDAO;

	public ProductServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		productDAO = new ProductDAO(entityManager);
		categoryDAO = new CategoryDAO(entityManager);
	}

	public void listProducts() throws ServletException, IOException {

		List<Product> productList = productDAO.listAll();
		request.setAttribute("productList", productList);

		String listpage = "product_list.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(listpage);
		dispatcher.forward(request, response);

	}

	public void showProductNewForm() throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();

		request.setAttribute("listCategory", listCategory);

		String Newpage = "product_form.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(Newpage);
		dispatcher.forward(request, response);

	}

}
