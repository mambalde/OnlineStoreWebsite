package com.OnlineStore.Controller.FrontEnd;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.DAO.ProductDAO;
import com.OnlineStore.Entity.Product;

@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		
	
		List<Product> newProducts = productDAO.listNewProducts();
		
		request.setAttribute("newProducts", newProducts);
	
		
		String page = "FrontEnd/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request,response);
	}

}
