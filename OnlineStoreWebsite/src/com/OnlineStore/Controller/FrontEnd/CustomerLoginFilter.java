package com.OnlineStore.Controller.FrontEnd;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class CustomerLoginFilter implements Filter {

	public CustomerLoginFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if (path.startsWith("/Admin/")) {

			chain.doFilter(request, response);
			return;
		}
		boolean loggenIn = session != null && session.getAttribute("loggedCustomer") != null;

		if (!loggenIn && path.startsWith("/view_profile")) {

			String loginPage = "FrontEnd/login.jsp";

			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(request, response);

		} else {

			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
