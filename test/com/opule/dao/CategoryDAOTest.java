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

	@Test
	public void testDeleteCategory() {
		Integer cateId = 12;
		categoryDao.delete(cateId);
		
		//Trying to retrive the category from the db by using the Id, should be null
		Category cate = categoryDao.get(cateId);
		assertNull(cate);
	}

	@Test
	public void testListAll() {
		List<Category> listCate = categoryDao.listAll();
		//print out list
		listCate.forEach(c -> System.out.println(c.getName() + ", "));
		
		//assert that list category size >0
		assertTrue(listCate.size() > 0);
		//look at hibernate statement
	}

	@Test
	public void testCount() {
		long NoCategories = categoryDao.count();
		
		assertEquals(6, NoCategories);
	}

}
