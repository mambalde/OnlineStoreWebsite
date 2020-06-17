package com.OnlineStore.Service;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.OnlineStore.DAO.CategoryDAO;
import com.OnlineStore.DAO.ProductDAO;
import com.OnlineStore.Entity.Category;
import com.OnlineStore.Entity.Product;

public class ProductServices {
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CategoryDAO categoryDAO;
	private ProductDAO productDAO;

	public ProductServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		productDAO = new ProductDAO(entityManager);
		categoryDAO = new CategoryDAO(entityManager);
	}

	public void listProducts() throws ServletException, IOException {
		listProducts(null);
	}
	public void listProducts(String message) throws ServletException, IOException {

		List<Product> productList = productDAO.listAll();
		request.setAttribute("productList", productList);

		if (message != null) {
			
			request.setAttribute("message", message);
		}

		String listpage = "product_list.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(listpage);
		dispatcher.forward(request, response);

	}

	public void showProductNewForm() throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();

		request.setAttribute("listCategory", listCategory);

		String Newpage = "product_form.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(Newpage);
		dispatcher.forward(request, response);

	}

	public void createProduct() throws IOException, ServletException {
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String name = request.getParameter("name");

		Product existentProduct = productDAO.findByName(name);
		if (existentProduct != null) {
			String message = "The product you are trying to create has already been created";
			listProducts(message);
			return;
		}
		String size = request.getParameter("size");
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");

		Product product = new Product();

		product.setProductName(name);
		product.setPrice(price);
		product.setDescription(description);
		product.setSize(size);

		Category Category = categoryDAO.get(categoryId);
		product.setCategory(Category);

		System.out.println(name + categoryId + size + price + description);

		Part part = request.getPart("productImage");

		if (part != null && part.getSize() > 0) {
			long Size = part.getSize();
			byte[] imagebytes = new byte[(int) Size];

			InputStream inputStream = part.getInputStream();
			inputStream.read(imagebytes);
			inputStream.close();

			product.setImage(imagebytes);
		}

		Product createdProduct = productDAO.create(product);

		if (createdProduct.getProductId() > 0) {
			String message = "The new product has been successfully created.";
			listProducts(message);
		}

	}

	public void editProduct() throws ServletException, IOException {
		
		Integer productId = Integer.parseInt(request.getParameter("id"));
		Product products = productDAO.get(productId);
		List<Category> listCategory = categoryDAO.listAll();
		
	
		request.setAttribute("products", products);
		request.setAttribute("listCategory", listCategory);
		String editpage = "product_form.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(editpage);
		dispatcher.forward(request, response);
	}

}
