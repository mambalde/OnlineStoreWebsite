package com.OnlineStore.Controller.FrontEnd;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.Controller.BaseServlet;
import com.OnlineStore.DAO.CategoryDAO;
import com.OnlineStore.Entity.Category;

@WebServlet("")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		List<Category> listCategory = categoryDAO.listAll();
		
		request.setAttribute("listCategory", listCategory);
		
		String page = "FrontEnd/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request,response);
	}

}
