package com.OnlineStore.Controller.FrontEnd.ShoppingCart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.DAO.ProductDAO;
import com.OnlineStore.Entity.Product;

@WebServlet("/view_cart")
public class ViewShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewShoppingCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Object cartObject = request.getSession().getAttribute("cart");
		if(cartObject == null) {
			ShoppingCart shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
			
			//ProductDAO productDAO = new ProductDAO();
		  //  Product product1 = productDAO.get(7);
		  //  Product product2 = productDAO.get(8);
		     
		//	shoppingCart.addItem(product1);
			//shoppingCart.addItem(product2);
		}

		//Product product = new Product();
		//product.setProductName("denim");
		//product.setPrice(10);
		
		//ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("cart");
		
		//shoppingCart.addItem(product);
		String cartPage = "FrontEnd/shopping_cart.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(cartPage);
		dispatcher.forward(request, response);
	}

}
