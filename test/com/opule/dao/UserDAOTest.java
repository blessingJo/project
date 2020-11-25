package com.opule.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.opule.entity.Users;

public class UserDAOTest extends CommonBaseDAOTest{
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		CommonBaseDAOTest.setUpBeforeClass();
		userDAO = new UserDAO(entityManager);
		
	}

	@Test
	public void testCreateUsers() {
		
		Users user1 = new Users();
		user1.setEmail("Chocolate@opuleaccessories.co");
		user1.setFullName("Chocolate Mangi");
		user1.setPassword("chocolate");
		
		
		user1 = userDAO.create(user1);
		
		assertTrue(user1.getUserId() > 0);
			
	}

	
	//If user inputs invalid/empty details. All User columns are NOT NULL. 
	//An exception is too be thrown because of invalid values.
	@Test(expected = PersistenceException.class)
	public void testCreateUsersInvalid() {
		Users user1 = new Users();
		user1 	= userDAO.create(user1);	
					
	}
	
	@Test
	public void testUpdateUsers() 	{
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("Hildah@opuleaccessories.co");
		user.setFullName("Hildah Makoni");
		user.setPassword("money");
		
		user = userDAO.update(user);
		String expected = "money";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
		
	}
	
	//public void testUpdateUsers() {
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		//print out name of the user found
		if (user != null) {
			System.out.println(user.getEmail()); //needed? because the user columns are NOT NULL
		}
		assertNotNull(user);
		
	}
	
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 201;
		Users user = userDAO.get(userId);
	
		assertNull(user);
	
		}
	
	@Test
	public void testDeleteUsers() {
		Integer userId = 1;
		userDAO.delete(userId);		
		Users user = userDAO.get(userId);
		assertNull(user);
				
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testUserNonExistent() {
		Integer userId = 189;
		userDAO.delete(userId);
	
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		
		for (Users user : listUsers) {
			System.out.println(user.getEmail());
				}		
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		assertEquals(2, totalUsers);
		
	}
	
	@Test
	public void testFindByEmail() {
		String email = "pbrown@opacc.co";
		Users user = userDAO.findByEmail(email);
		
		assertNotNull(user);
	}
	
	
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		CommonBaseDAOTest.tearDownAfterClass();
	}
	}
	
	

