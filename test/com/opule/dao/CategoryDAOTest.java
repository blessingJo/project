package com.opule.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.opule.entity.Category;

public class CategoryDAOTest extends CommonBaseDAOTest{
	
	private static CategoryDAO categoryDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		CommonBaseDAOTest.setUpBeforeClass();
		categoryDao = new CategoryDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		CommonBaseDAOTest.tearDownAfterClass();
	}

	@Test
	public void testCreateCategory() {
		Category newCategory = new Category("Bracelet");
		Category categoryTest = categoryDao.create(newCategory);
		
		//this method retuns a newly created category object
		//assert that category object is not null and category Id is >0
		
		assertTrue(categoryTest!=null && categoryTest.getCategoryId() > 0);
		
	}

	@Test
	public void testUpdateCategory() {
		Category categoryName = new Category("bracelet");
		categoryName.setCategoryId(14);
		
		Category category = categoryDao.update(categoryName);
		
		assertEquals(categoryName.getName(), category.getName());
	}

	@Test
	public void testGet() {
		Integer	categoryId = 14;
		Category category1 = categoryDao.get(categoryId);
		
		assertNotNull(category1);
	}
	
	//test case for delete category
	@Test 
	public void testDeleteCategory() {
		Integer cateId = 12;
		categoryDao.delete(cateId);
		
		//Trying to retrieve the category from the db by using the Id, should be null
		Category cate = categoryDao.get(cateId);
		assertNull(cate);
	}

	//test case for listAll method - should return a list of all categories in console
	@Test
	public void testListAll() {
		List<Category> listCate = categoryDao.listAll();
		//print out list
		listCate.forEach(c -> System.out.println(c.getName() + ", "));
		
		//assert that list category size >0
		assertTrue(listCate.size() > 0);
		//look at hibernate statement
	}
	
	//test case for findByName JPQL query - test passes if the category exists in the database
	@Test
	public void testFindByName() {
		String name = "Earrings";
		//calling findByName method in categoryDAO
		Category cate = categoryDao.findByName(name);
		//
		assertNotNull(cate);
	}
		
		
	//searches for cateName that doesnt exist in database	
		@Test
		public void testCategoryDoesntExist() {
			String name = "jewel";
			//calling findByName method in categoryDAO
			Category cate = categoryDao.findByName(name);
			//
			assertNull(cate);
		
	
	}
	//test case fot the count method
	@Test
	public void testCount() {
		long NoCategories = categoryDao.count();
		
		assertEquals(6, NoCategories);
	}
	
	

}
