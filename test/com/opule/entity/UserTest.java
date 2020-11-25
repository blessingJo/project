package com.opule.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.opule.entity.Users;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Users user1 = new Users();
		user1.setEmail("baby@codejava.net");
		user1.setFullName("YesSirr Money");
		user1.setPassword("loveyou");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OpuleWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(user1);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("A user object was persisted");
		
	}

}
