package com.opule.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.opule.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(EntityManager entityManager) {
		
		super(entityManager);
		
	}

	@Override
	//calls the category method in Category class
	public Category create(Category category) {
		return super.create(category);
	}
	
	@Override
	public Category update(Category category) {
		return super.update(category);
	}
	
	@Override
	//retrieves category by the id
	public Category get(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	//deletes object by id
	public void delete(Object id) {
		super.delete(Category.class,  id);
	}

	@Override
	//uses JPQL query findAll to retrieve the list
	public List <Category>  listAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	//uses JPQL query in the entity class Category to count the number of categories
	public long count() {
		return super.countWithNamedQuery("Category.countAll");
	}
	//findByName JPQL query to find category by its name - when the admin is creating a new category
	public Category findByName(String categoryName) {
		List<Category> result = super.findWithNamedQuery("Category.findByName", "name", categoryName );
		//check if the returned list is empty or not -> 
		//then return the first element in the collection, which is the first category object that is found
		
		if (result != null && result.size() > 0) {
			return result.get(0); //return first element at 0 index
		}
		
	
		return null;
		
	}



	
}
