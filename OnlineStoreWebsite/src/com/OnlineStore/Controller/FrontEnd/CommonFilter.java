package com.OnlineStore.Controller.FrontEnd;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.OnlineStore.DAO.CategoryDAO;
import com.OnlineStore.Entity.Category;

@WebFilter("/*")
public class CommonFilter implements Filter {
	private final CategoryDAO categoryDAO;
	

	public CommonFilter() {
		categoryDAO = new CategoryDAO();

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if(!path.startsWith("/Admin/")){
		List<Category> listCategory = categoryDAO.listAll();

		request.setAttribute("listCategory", listCategory);
		
		}
		
		System.out.println("commun filter->doFilter"+path);

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
