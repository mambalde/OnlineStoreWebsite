package com.OnlineStore.Controller.Admin.Product;

import com.OnlineStore.Controller.BaseServlet;
import com.OnlineStore.Service.ProductServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin/list_product")
public class ListProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public ListProductServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductServices productServices = new ProductServices(entityManager, request, response);
		productServices.listProducts();
	}

}