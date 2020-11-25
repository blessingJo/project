package com.opule.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.opule.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public Users create(Users user) {
		return super.create(user);
	}
	
	
	@Override
	public Users update(Users user) {
		return super.update(user);
	}

	@Override
	public Users get(Object userId) {
		return super.find(Users.class, userId);
	}

	@Override
	public void delete(Object userId) {
		super.delete(Users.class, userId);
		
	}

	//returns all users from the table
	@Override
	public List<Users>listAll() {
		return super.findWithNamedQuery("Users.findAll");
}

	@Override
	public long count() {
		return super.countWithNamedQuery("Users.countAll");
	}

	public Users findByEmail(String email) {
		//query defined in Users class. Purpose is check that the newly created user doesn't have an email that exists already in the db
		List<Users> listUsers = super.findWithNamedQuery("Users.findByEmail", "email", email);
		
		if(listUsers != null && listUsers.size() > 0) {
			return listUsers.get(0);
		}
		
		return null;
	}
	
}
