package com.OnlineStore.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.OnlineStore.Entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Category create(Category category) {

		return super.create(category);
	}

	@Override
	public Category update(Category category) {

		return super.update(category);
	}

	@Override
	public Category get(Object id) {

		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id);

	}

	@Override
	public List<Category> listAll() {

		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("Category.countAll");
	}

	public Category findByName (String categoryName){
		List<Category> result = super.findWithNamedQuery("Category.findByName", "name", categoryName);
		if(result != null && result.size()>0){
			return result.get(0);
		}
		return null;
	}
}
