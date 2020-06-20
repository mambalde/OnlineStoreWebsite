package com.OnlineStore.Controller.Admin.Customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.Service.CustomerServices;

@WebServlet("/Admin/update_customer")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCustomerServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CustomerServices customerServices = new CustomerServices(request, response);
		customerServices.updateCustomer();
		
	}

}
