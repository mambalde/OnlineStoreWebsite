package com.OnlineStore.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OnlineStore.DAO.CustomerDAO;
import com.OnlineStore.DAO.HashGenerator;
import com.OnlineStore.Entity.Customer;
import com.OnlineStore.Service.CommonUtility;

public class CustomerServices extends CommonUtility {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerDAO customerDAO;

	public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		customerDAO = new CustomerDAO();
	}

	public void listCustomer(String message) throws ServletException, IOException {
		List<Customer> listCustomer = customerDAO.listAll();
		if (message != null) {
			request.setAttribute("message", message);
		}

		request.setAttribute("listCustomer", listCustomer);

		String listpage = "customer_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listpage);
		dispatcher.forward(request, response);
	}

	public void listCustomer() throws ServletException, IOException {
		listCustomer(null);
	}

	public void createCustomer() throws ServletException, IOException {

		String email = request.getParameter("email");
		Customer existCustomer = customerDAO.findByEmail(email);

		if (existCustomer != null) {

			String message = "Could not create customer :" + email + "is already registered by another Customer";
			listCustomer(message);
		} else {

			Customer newCustomer  = new Customer();
			
			updateCustomerFieldsFromForm(newCustomer);
			customerDAO.create(newCustomer);

			String message = "The new Custome has been successfully created";
			listCustomer(message);

		}

	}
	
	private void updateCustomerFieldsFromForm(Customer customer){
		
		String fullname = request.getParameter("name");
		 String email = request.getParameter("email");
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String password = request.getParameter("password");
		String zipcode = request.getParameter("zipcode");
		String phone = request.getParameter("phone");
		
		if (email != null && !email.equals("")) {
			customer.setEmail(email);
		}
		
		customer.setFullname(fullname);
		
		if (password != null & !password.isEmpty()) {
			String encryptedPassword = HashGenerator.generateMD5(password);
			customer.setPassword(encryptedPassword);				
		}		
		
		customer.setAddress(address);
		customer.setFullname(fullname);
		customer.setCountry(country);
		customer.setCity(city);
		customer.setZipcode(zipcode);
		customer.setPhone(phone);

		
	}

	public void registerCustomer() throws ServletException, IOException {

		String email = request.getParameter("email");
		Customer existCustomer = customerDAO.findByEmail(email);
		String message = "";

		if (existCustomer != null) {

			message = "You are already a registered Customer please login instead!";
		} else {
			
           Customer newCustomer  = new Customer();
			
			updateCustomerFieldsFromForm(newCustomer);
			customerDAO.create(newCustomer);

			message = "Registration Successful!<br/>" + "<a href='login'> Click here</a> to login";
			showMessageFrontend(message, request, response);
		}

	}

	public void editCustomer() throws ServletException, IOException {

		Integer customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDAO.get(customerId);

		if (customer == null) {
			String message = "Could not find customer with ID " + customerId;
			showMessageBackend(message, request, response);
		} else {
			
			customer.setPassword(null);
			request.setAttribute("customer", customer);
			forwardToPage("customer_form.jsp", request, response);
		}
	}

	public void updateCustomer() throws ServletException, IOException {

		Integer customerId = Integer.parseInt(request.getParameter("customerId"));
		String email = request.getParameter("email");
		Customer customerByEmail = customerDAO.findByEmail(email);

		String message = null;

		if (customerByEmail != null && customerByEmail.getCustomerId() != customerId) {
			message = "failed to update the customer's details this email  is already in use";
		} else {

			

			Customer customerById = customerDAO.get(customerId);

			updateCustomerFieldsFromForm(customerById);

			customerDAO.update(customerById);

			message = "The Customer's details has been successfully updated";

		}
		listCustomer(message);
	}

	public void deleteServlet() throws ServletException, IOException {

		Integer customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDAO.get(customerId);

		if (customer != null) {

			customerDAO.delete(customerId);

			String message = "The customer has been deleted successfully.";
			listCustomer(message);
		} else {
			String message = "Could not find customer with ID " + customerId + ", "
					+ "or it has been deleted by another admin";
			showMessageBackend(message, request, response);
		}
		// customerDAO.delete(customerId);

	}

	public void showLogin() throws ServletException, IOException {

		String loginPage = "FrontEnd/login.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
		dispatcher.forward(request, response);

	}

	public void doLogin() throws ServletException, IOException {

		String message = "";
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Customer customer = customerDAO.checkLogin(email, password);

		if (customer == null) {
			message = "Login failed! please check your password and email";
			request.setAttribute("message", message);
			showLogin();
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loggedCustomer", customer);
			Object objRedirectURL = session.getAttribute("redirectURL");
			
			if(objRedirectURL != null) {
				String redirectURL = (String) objRedirectURL;
				session.removeAttribute(redirectURL);
				response.sendRedirect(redirectURL);
			}else{
				showCustomerProfile();
			}

		}

	}
	
	public void showCustomerProfile() throws ServletException, IOException {
		
		String profilePage = "FrontEnd/customer_profile.jsp";
		RequestDispatcher dispatcher =  request.getRequestDispatcher(profilePage);
		dispatcher.forward(request, response);
		
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		
		String EditprofilePage = "FrontEnd/edit_profile.jsp";
		RequestDispatcher dispatcher =  request.getRequestDispatcher(EditprofilePage);
		dispatcher.forward(request, response);
		
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		updateCustomerFieldsFromForm(customer);
		
		customerDAO.update(customer);
		showCustomerProfile();
		
	}

}
