package com.OnlineStore.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.DAO.CategoryDAO;
import com.OnlineStore.DAO.ProductDAO;
import com.OnlineStore.Entity.Category;

public class CategoryServices {
	private CategoryDAO categoryDAO;

	private HttpServletRequest request;
	private HttpServletResponse response;

	public CategoryServices( HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		categoryDAO = new CategoryDAO();

	}

	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listcategory = categoryDAO.listAll();

		request.setAttribute("listcategory", listcategory);
		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "category_list.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);

	}

	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}

	public void CreateCategory() throws ServletException, IOException {
		String name = request.getParameter("name");

		Category existCategory = categoryDAO.findByName(name);
		if (existCategory != null) {
			String message = "A category with the same name already exists";
			request.setAttribute("message", message);

			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);

		} else {
			Category newCategory = new Category(name);
			categoryDAO.create(newCategory);

			String message = "A new Category Has Been Successfully Created";
			listCategory(message);

		}

	}

	public void editCategory() throws ServletException, IOException {
		int catergoyId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(catergoyId);
		String editPage = "category_form.jsp";
		if (category != null) {
			request.setAttribute("category", category);
		} else {
			String message = "could not find category with id " + catergoyId;
			request.setAttribute("message", message);
			editPage = "message.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);

	}

	public void updateCategory() throws ServletException, IOException {
		int catergoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("name");
		Category categoryById = categoryDAO.get(catergoryId);
		Category categoryByName = categoryDAO.findByName(categoryName);

		if (categoryByName != null && categoryById.getCategoryId() != categoryByName.getCategoryId()) {

			String message = "Category with that name already exist";

			request.setAttribute("message", message);

			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);

		}

		else {

			categoryById.setName(categoryName);
			categoryDAO.update(categoryById);
			String message = "category Has Been Successfully Updated";
			listCategory(message);
		}

	}

	public void deleteCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		ProductDAO productDAO = new ProductDAO();
		
		long numberOfProducts = productDAO.countByCategory(categoryId);
		Category category = categoryDAO.get(categoryId);
		
		String message;
		if(numberOfProducts>0){
			
			message = "Could not delete the Category (ID: %d) because it contains some books";
			message= String.format(message, numberOfProducts);
		}
		else if(category==null){
			 message = "category could not be found or has been deleted";
			
		}else{
			categoryDAO.delete(categoryId);
			message = "Category has been successfully removed";
		}
			
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
		

		listCategory(message);
		
	}
}
