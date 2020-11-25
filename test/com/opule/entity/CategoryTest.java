package com.opule.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
Category categoryOne = new Category("Earrings");
		
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OpuleWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(categoryOne);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("A category Object was Persisted");

	}

}
