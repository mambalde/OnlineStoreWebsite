package com.OnlineStore.Controller.FrontEnd.ShoppingCart;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update_cart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCartServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] arrayProductIds = request.getParameterValues("productId");
		String[] arrayQuantites = new String[arrayProductIds.length];
		for(int i=1; i<=arrayQuantites.length; i++){
			String aQuantity = request.getParameter("quantity"+i);
			arrayQuantites[i-1] = aQuantity;
		}
		
		int[] productIds = Arrays.stream(arrayProductIds).mapToInt(Integer::parseInt).toArray();
		int[] quantities = Arrays.stream(arrayQuantites).mapToInt(Integer::parseInt).toArray();
		
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		cart.updateCart(productIds, quantities);
		
		
		String cartPage = request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);
	}

}
