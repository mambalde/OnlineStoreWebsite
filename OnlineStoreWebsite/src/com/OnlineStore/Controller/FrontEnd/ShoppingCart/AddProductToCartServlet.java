package com.OnlineStore.Controller.FrontEnd.ShoppingCart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.DAO.ProductDAO;
import com.OnlineStore.Entity.Product;

@WebServlet("/add_to_cart")
public class AddProductToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProductToCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer productId = Integer.parseInt(request.getParameter("product_id"));
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingCart = null;
		if(cartObject != null && cartObject instanceof ShoppingCart){
			shoppingCart = (ShoppingCart) cartObject;
		}else{
			shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
		}
		
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.get(productId);
		shoppingCart.addItem(product);
		
		String cartPage = request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);
	}

}
