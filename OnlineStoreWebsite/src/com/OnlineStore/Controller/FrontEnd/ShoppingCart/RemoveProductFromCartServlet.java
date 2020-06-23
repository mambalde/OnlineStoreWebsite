package com.OnlineStore.Controller.FrontEnd.ShoppingCart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.DAO.ProductDAO;
import com.OnlineStore.Entity.Product;

@WebServlet("/remove_from_cart")
public class RemoveProductFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveProductFromCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		Integer productId = Integer.parseInt(request.getParameter("product_id"));
		Object cartObject = request.getSession().getAttribute("cart");
		
		
		ShoppingCart shoppingCart = (ShoppingCart) cartObject;
		
		shoppingCart.removeItem(new Product(productId));
		
		String cartPage = request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);
	}

}
