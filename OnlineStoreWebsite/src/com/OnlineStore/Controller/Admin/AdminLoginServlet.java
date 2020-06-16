package com.OnlineStore.Controller.Admin;

import com.OnlineStore.Controller.BaseServlet;
import com.OnlineStore.Service.UserServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin/login")
public class AdminLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		UserServices userServices = new UserServices(entityManager, request, response);
		userServices.checkLogin();
		
	}

}
