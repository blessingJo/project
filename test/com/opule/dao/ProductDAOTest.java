package com.opule.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.opule.entity.Category;
import com.opule.entity.Product;
//import com.sun.org.apache.xml.internal.utils.URI;
//import com.sun.org.apache.xerces.internal.util.URI;

public class ProductDAOTest extends CommonBaseDAOTest{

	private static ProductDAO productDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		CommonBaseDAOTest.setUpBeforeClass();
		productDao = new ProductDAO(entityManager);
	}


//	@Before
//	public void setUp() throws Exception {
//	}

	@Test
	public void testCreateProduct() throws IOException {
		
		Product newProduct = new Product();
		
		Category category = new Category("Earrings");
		category.setCategoryId(13);
		newProduct.setCategory(category);
		
		newProduct.setTitle("testing");
		newProduct.setDescription("fdjosdo");
		newProduct.setPrice(40.88f);
		
		String imagePath =  "/Applications/uniwork/FinalProjectt/productInformation/hoopEarrings.jpeg";
		byte []imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newProduct.setImage(imageBytes);
		
		Product createProduct = productDao.create(newProduct);
		assertTrue(createProduct.getProductId() > 0);
	}
	
	@Test
	public void testUpdateProduct() throws IOException {
		
		Product existProduct = new Product();
		existProduct.setProductId(35);
		
		Category category = new Category("Necklace");
		category.setCategoryId(15);
		existProduct.setCategory(category);
		
		existProduct.setTitle("hoops");
		existProduct.setDescription("fdjosdo");
		existProduct.setPrice(11.99f);
		
		String imagePath =  "/Applications/uniwork/FinalProjectt/productInformation/hoopEarrings.jpeg";
		byte []imageBytes = Files.readAllBytes(Paths.get(imagePath));
		existProduct.setImage(imageBytes);
		
		Product updateProduct = productDao.update(existProduct);
		assertEquals(updateProduct.getTitle(), "hoops");
		
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteProductFailed() {
		Integer productId = 109;
		productDao.delete(productId);
		
	}
	
	@Test
	public void testDeleteProductPass() {
		Integer productId = 37;
		productDao.delete(productId);
		
		assertTrue(true);
		
	}
	
	@Test//(expected = EntityNotFoundException.class)
	public void testGetProductFailed() {
		Integer productId = 89;
		Product product = productDao.get(productId);
	
		assertNull(product);
	}
	
	@Test//(expected = EntityNotFoundException.class)
	public void testGetProductSuccessful() {
		Integer productId = 35;
		Product product = productDao.get(productId);
	
		assertNotNull(product);
	}
	
	@Test
	public void testGetAll() {
		List<Product> listProducts = productDao.listAll();
		
			for (Product product :listProducts) {
				System.out.println(product.getTitle());
			}
		
		assertFalse(listProducts.isEmpty());
		
	}
	
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	CommonBaseDAOTest.tearDownAfterClass();
	}

}
