package com.OnlineStore.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/")
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public void destroy() {
	
		entityManager.close();
		entityManagerFactory.close();
	}

}
