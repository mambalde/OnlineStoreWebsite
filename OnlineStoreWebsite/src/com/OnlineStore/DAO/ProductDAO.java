package com.OnlineStore.DAO;

import java.util.List;

import com.OnlineStore.Entity.Product;

public class ProductDAO extends JpaDAO<Product> implements GenericDAO<Product> {

	public ProductDAO() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public Product create(Product product) {
		return super.create(product);
	}
	
	
	
	public Product Update(Product product){
		
		return super.update(product);
	}
	@Override
	public Product get(Object productId) {
		
		return super.find(Product.class, productId);
	}

	@Override
	public void delete(Object productId) {
		super.delete(Product.class, productId);
	}

	@Override
	public List<Product> listAll() {
		
		return super.findWithNamedQuery("Product.findAll");
	}
	
	public Product findByName(String productName){
		List<Product> productList = super.findWithNamedQuery("Product.findByName", "productName", productName);
		
		if(!productList.isEmpty()){
			return productList.get(0);
		}
		return null;
	}
	
	public List<Product> listByCategory(int categoryId){
		
		return super.findWithNamedQuery("Product.findByCategory", "catId", categoryId);
	}
	
   public List<Product> search(String keyword){
		
		return super.findWithNamedQuery("Product.search", "keyword", keyword);
	}
	
	
	
	public List<Product> listNewProducts(){
		
		return super.findWithNamedQuery("Product.ListNew", 0, 5);
		
	}
	
	@Override
	public long count() {
		
		return super.countWithNamedQuery("Product.countAll");
		
	}
	
   public long countByCategory(int categoryId) {
		
		return super.countWithNamedQuery("Product.countByCategory", "catId", categoryId);
	}

}
