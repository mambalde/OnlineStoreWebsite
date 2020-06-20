package com.OnlineStore.Controller.Admin.Product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.Service.ProductServices;

@WebServlet("/Admin/create_product")
@MultipartConfig(fileSizeThreshold = 1024 * 10, maxFileSize = 1024 * 300, maxRequestSize = 1024 * 1024)
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateProductServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductServices productServices = new ProductServices(request, response);
		productServices.createProduct();
	}

}
