package com.opule.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.opule.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}
	//implementing create method defined by GenericDAO interface
	public Users create(Users user) {
		return super.create(user);
	}
	
	//Implementing update method defined by genericDAO interface
	@Override
	public Users update(Users user) {
		return super.update(user);
	}

	//implementing get method defined by genericDAO interface
	@Override
	public Users get(Object userId) {
		return super.find(Users.class, userId);
	}
	//Implementing delete method defined by genericDAO interface
	@Override
	public void delete(Object userId) {
		super.delete(Users.class, userId);
		
	}

	//returns all users from the table by using a JPQL query 
	@Override
	public List<Users>listAll() {
		return super.findWithNamedQuery("Users.findAll");
}
	//implementing count method defined by genericDAO. Uses JPQL query to retrieve data from db
	@Override
	public long count() {
		return super.countWithNamedQuery("Users.countAll");
	}

	//checking that the email of the newly created user doesn't exist already in the db 
	public Users findByEmail(String email) {
		//query defined in Users class. Purpose is check that the newly created user doesn't have an email that exists already in the db
		List<Users> listUsers = super.findWithNamedQuery("Users.findByEmail", "email", email);
		
		if(listUsers != null && listUsers.size() > 0) {
			return listUsers.get(0);
		}
		
		return null;
	}
	
}
