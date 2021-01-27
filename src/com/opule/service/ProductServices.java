package com.opule.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.opule.dao.CategoryDAO;
import com.opule.dao.ProductDAO;
import com.opule.entity.Category;
import com.opule.entity.Product;


public class ProductServices {
	private EntityManager entityManager;
	//CategoryDAO class requires an entity Manager from EMF
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;
	


	public ProductServices(EntityManager entityManager, HttpServletRequest request,
			HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		//this.categoryDAO = categoryDAO;
		//this.request = request;
		productDAO = new ProductDAO(entityManager);
		categoryDAO = new CategoryDAO(entityManager);

	}
	
	public void listProducts() throws ServletException, IOException {
		listProducts(null);
	}

	public void listProducts(String message) throws ServletException, IOException {
		
	//returns list objects
		List<Product> listProducts = productDAO.listAll();
		//store collection of products in  a request attribute
		request.setAttribute("listProducts",  listProducts);
		//then forward the products to productlist jsp page using a dispatcher
		String pageList = "product_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageList);
		//forwarding the request
		requestDispatcher.forward(request,  response);
		// TODO Auto-generated method stub
	}
		
	
		public void newProductForm() throws ServletException, IOException {
			//retrieve a list of the catgogies 
			List<Category> listCategory = categoryDAO.listAll();
			//storing the objects in a request attribute
			request.setAttribute("listCategory",  listCategory);
			//then forward the products to productlist jsp page using a dispatcher
			String e = "product_form.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(e);
			//forwarding the request
			requestDispatcher.forward(request, response);
			
		}
		
		public void readProductFields(Product product) throws IOException, ServletException {
			Integer categoryId = Integer.parseInt(request.getParameter("categoryId")); 
			
			//String category = request.getParameter("category");
			String title = request.getParameter("title");
			
			//checking that the title doesn't exist already 
			//Product existingProductTitle = productDAO.findByTitle(title);
				//String message = "Product could not be created because the title" + productTitle +" is already assigned to another product";
				//request.setAttribute("message", message);
			float productPrice = Float.parseFloat(request.getParameter("price"));
			String description = request.getParameter("description");
			
			
			//new product object 
			//Product product = new Product();
			
			Category categories = categoryDAO.get(categoryId);
			//Category categories = categoryDAO.get(Integer.parseInt(categories));
			product.setCategory(categories); 
			//setting the values
			product.setTitle(title);
			//retrieve a category from the database and set the category object to the product object
			//use of category DAO class			
			
			product.setPrice(productPrice);
			product.setDescription(description);
			
			//retrieve image data from the multi part request, throws IO exception
			//read the data of the file uploaded in create product form into an array of bytes
			Part multipart = request.getPart("productImage");
			byte [] imageBytes = null;
			//check if path is not null 
			if (multipart != null && multipart.getSize() > 0) {
				long size = multipart.getSize(); //get the size of the part
				imageBytes = new byte[(int) size];  //create an array of bytes,cast to int 
				
				//open the input steam from the part
				InputStream iStream = multipart.getInputStream();
				//read to a byte array imageBytes
				iStream.read(imageBytes);
				//close the input stream
				iStream.close();
				
				//set the array of bytes of the image to the product
				product.setImage(imageBytes);
			}
			
		}

		public void createProduct() throws IOException, ServletException {
			//reading all the fields submitted in create product form
			
		//	Integer categoryId = Integer.parseInt(request.getParameter("category")); 
			String title = request.getParameter("title");
			
			Product newProduct = new Product();
			readProductFields(newProduct);
			
		//read the data into a byte array from the path if condition is met
		
			//calling create method in productDAO to save the newly created product
			
			Product createdProduct = productDAO.create(newProduct);
			
			//checking if the product has been created successfully and displaying a message
			
			if (createdProduct.getProductId() > 0) {
				String message = "The new product has been successfully created";	
				
				//setting the message as request attribute
				request.setAttribute("message", message);
				//refresh the list of products
				listProducts(); 		
				
			}
		
		}
		
		public void editProduct() throws ServletException, IOException {
			//call productDAO to get details of the product, such as the productID
			Integer produId = Integer.parseInt(request.getParameter("productId")); 
			//returns a product object
			Product product = productDAO.get(produId);
			//setting the product as an attribute in request so it's available in the edit form
			List<Category> listCategory = categoryDAO.listAll();
			
			request.setAttribute("product", product);
			request.setAttribute("listCategory", listCategory);
			
			String editPa = "product_form.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPa);
			requestDispatcher.forward(request, response);
					
		}
		
		

		public void updateProduct() throws IOException, ServletException {
			
			// getting the productID from the form
			System.out.println("Product ID: " + request.getParameter("productId"));
			Integer productId = Integer.parseInt(request.getParameter("productId"));
			
			Product existingProduct = productDAO.get(productId);
			//retrieving the existing product in the database and updating it with the new valuesin the form
			//readinf values from the form 
			readProductFields(existingProduct); 
			
			productDAO.update(existingProduct);
			
			String message = "The product has been successfully created";
			listProducts(message);
			
		}
	 

}
