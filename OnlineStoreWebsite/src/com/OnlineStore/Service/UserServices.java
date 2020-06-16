package com.OnlineStore.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineStore.DAO.HashGenerator;
import com.OnlineStore.DAO.UserDAO;
import com.OnlineStore.Entity.Users;

public class UserServices {
	private UserDAO userDAO;

	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

		this.request = request;
		this.response = response;

		userDAO = new UserDAO(entityManager);

	}

	public void listUsers() throws ServletException, IOException {

		listUsers(null);

	}

	public void listUsers(String message) throws ServletException, IOException {
		List<Users> listUsers = userDAO.listAll();

		request.setAttribute("listUsers", listUsers);

		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);

	}

	public void CreateUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");

		Users existingUser = userDAO.findByEmail(email);
		if (existingUser != null) {
			String message = "User with that email already exist";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);

		} else {

			Users newUsers = new Users(email, fullName, password);
			userDAO.create(newUsers);
			listUsers("New User Created Successfully");
		}

	}

	public void editUser() throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("id"));
		Users users = userDAO.get(userId);

		if (users != null) {

			String editPage = "user_form.jsp";
			
			users.setPassword(null);
			request.setAttribute("users", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
			dispatcher.forward(request, response);

		} else {
			String message = "User Does Not Exist:";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}

	}

	public void updateUser() throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));

		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");

		Users usersById = userDAO.get(userId);
		Users usersByEmail = userDAO.findByEmail(email);

		if (usersByEmail != null && usersByEmail.getUserId() != usersById.getUserId()) {

			String message = "Failed to Update User's Details";
			request.setAttribute("message", message);

			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);

		} else {
			
			usersById.setEmail(email);
			usersById.setFullname(fullname);
			
			if (password != null & !password.isEmpty()) {
				String encryptedPassword = HashGenerator.generateMD5(password);
				usersById.setPassword(encryptedPassword);				
			}

			//Users users = new Users(userId, email, fullname, password);
			userDAO.update(usersById);

			String mesage = "User's details has been successfully updated";
			listUsers(mesage);
		}
	}

	public void deleteUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		userDAO.delete(userId);
		String mesage = "User Has Been Deleted Successfully:";
		listUsers(mesage);
	}

	public void checkLogin() throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean loginResult = userDAO.checkLogin(email, password);

		if (loginResult) {

			request.getSession().setAttribute("useremail", email);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/");
			dispatcher.forward(request, response);

		} else {

			String message = "Login failed! try again";

			request.setAttribute("message", message);

			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		}
	}

}
