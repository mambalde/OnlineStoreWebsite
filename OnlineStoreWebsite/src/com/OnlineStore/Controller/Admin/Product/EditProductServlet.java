package com.OnlineStore.Controller.Admin.Product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.Service.ProductServices;

@WebServlet("/Admin/edit_product")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProductServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		ProductServices productServices = new ProductServices(request, response);
		productServices.editProduct();
	}

}
