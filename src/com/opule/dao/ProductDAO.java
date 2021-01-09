package com.opule.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.ProductntityManager;

import com.opule.entity.Product;

public class ProductDAO extends JpaDAO<Product> implements GenericDAO<Product> {

	public ProductDAO(EntityManager entityManager) {
		
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product create(Product product) {
		return super.create(product); //delegating the code to its superclass
		
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return super.update(product);
	}

	@Override
	public Product get(Object productId) {
		return null;
	}

	@Override
	public void delete(Object productId) {
		super.delete(Product.class,  productId);	
		// TODO Auto-generated method stub
		
	}

	@Override
	public List listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
