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

		String name = request.getParameter("name");
		Product existentProduct = productDAO.findByName(name);
		if (existentProduct != null) {
			String message = "The product you are trying to create has already been created";
			listProducts(message);
			return;
		}

		Product newProduct = new Product();
		readProductFields(newProduct);
		Product createdProduct = productDAO.create(newProduct);

		if (createdProduct.getProductId() > 0) {
			String message = "The new product has been successfully created.";
			listProducts(message);
		}

	}

	public void readProductFields(Product product) throws IOException, ServletException {

		String name = request.getParameter("name");
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String size = request.getParameter("size");
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");

		// Product newproduct = new Product();

		product.setProductName(name);
		product.setPrice(price);
		product.setDescription(description);
		product.setSize(size);

		Category Category = categoryDAO.get(categoryId);
		product.setCategory(Category);

		// System.out.println(name + categoryId + size + price + description);

		Part part = request.getPart("productImage");

		if (part != null && part.getSize() > 0) {
			long Size = part.getSize();
			byte[] imagebytes = new byte[(int) Size];

			InputStream inputStream = part.getInputStream();
			inputStream.read(imagebytes);
			inputStream.close();

			product.setImage(imagebytes);
		}

	}

	public void editProduct() throws ServletException, IOException {

		Integer productId = Integer.parseInt(request.getParameter("id"));
		Product products = productDAO.get(productId);
		String editpage = "product_form.jsp";

		if (products != null) {

			List<Category> listCategory = categoryDAO.listAll();

			request.setAttribute("products", products);
			request.setAttribute("listCategory", listCategory);
		} else {
			editpage = "message.jsp";
			String message = "Could not find product with ID " + productId;
			request.setAttribute("message", message);

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(editpage);
		dispatcher.forward(request, response);
	}

	public void updateProduct() throws IOException, ServletException {

		Integer productId = Integer.parseInt(request.getParameter("productId"));
		String name = request.getParameter("name");

		Product existProduct = productDAO.get(productId);
		Product productByName = productDAO.findByName(name);

		if (!existProduct.equals(productByName)) {

			String message = "failed to update! product's name must be unique";
			listProducts(message);
			return;

		}

		readProductFields(existProduct);

		productDAO.Update(existProduct);

		String message = "the product has been successfully updated";
		listProducts(message);
	}

	public void deleteProduct() throws ServletException, IOException {

		Integer productId = Integer.parseInt(request.getParameter("id"));

		Product product = productDAO.get(productId);

		if (product == null) {
			String message = "Could not find product with ID " + productId + ", or it might have been deleted";
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		} else {

			productDAO.delete(productId);
			String message = "product has been successfully deleted";
			listProducts(message);

		}

	}

	public void listProductsByCategory() throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		List<Product> listOfProducts = productDAO.listByCategory(categoryId);
		Category category = categoryDAO.get(categoryId);
		
		
		if(category == null) {
			
			String message = "Sorry, the category ID " + categoryId + " is not available.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("FrontEnd/message.jsp").forward(request, response);
			
			return;
		}else{
			
			List<Category> listCategory = categoryDAO.listAll();

			request.setAttribute("listCategory", listCategory);
			request.setAttribute("listOfProducts", listOfProducts);
			request.setAttribute("category", category);
			
			String displayPage = "FrontEnd/products_list_by_category.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
			dispatcher.forward(request, response);
		}

	
	}

	public void viewProductDetails() throws ServletException, IOException {
		
		Integer productId = Integer.parseInt(request.getParameter("id"));
		
		Product product = productDAO.get(productId);
		String detailsPage = "FrontEnd/product_detail.jsp";

		List<Category> listCategory = categoryDAO.listAll();

		
		if (product != null) {
			
			request.setAttribute("listCategory", listCategory);
			request.setAttribute("product", product);
			
		}else{
			
			detailsPage = "FrontEnd/message.jsp";
			String message = "Sorry, the product with ID " + productId + " is not available.";
			request.setAttribute("message", message);		
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailsPage);
		dispatcher.forward(request, response);
		
		
	}

}
