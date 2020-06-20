package com.OnlineStore.Controller.FrontEnd.Customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class ShowCustomerRegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowCustomerRegisterFormServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String registerForm = "FrontEnd/register_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(registerForm);
		dispatcher.forward(request, response);
		
	}

}
