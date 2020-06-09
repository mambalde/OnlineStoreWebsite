package com.OnlineStore.Controller.Admin.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.Controller.Admin.BaseServlet;
import com.OnlineStore.Service.UserServices;

@WebServlet("/Admin/create_user")
public class CreateUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public CreateUserServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserServices userServices = new UserServices(entityManager, request, response);
		userServices.CreateUser();

	}

}
