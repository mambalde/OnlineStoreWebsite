package com.OnlineStore.Controller.Admin.Product;

import com.OnlineStore.Controller.BaseServlet;
import com.OnlineStore.Service.ProductServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin/update_product")
@MultipartConfig(fileSizeThreshold = 1024 * 10, maxFileSize = 1024 * 300, maxRequestSize = 1024 * 1024)
public class UpdateProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProductServlet() {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductServices productServices = new ProductServices(entityManager, request, response);
		productServices.updateProduct();
			
	}

}
