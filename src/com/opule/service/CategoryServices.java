package com.opule.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.dao.CategoryDAO;
import com.opule.dao.UserDAO;
import com.opule.entity.Category;

public class CategoryServices {
	private EntityManager entityManager;
	private CategoryDAO categoryDAO;
	//CategoryDAO class requires an entity Manager from EMF
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	
	public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		//super();
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		
		
		//instance of the categoryDAO
		//CATEGORYsERVICES CLASS needs to have a constructor that accepts an EntityManager
		//which is from the basis class
		categoryDAO  = new CategoryDAO(entityManager);
		
		
		
	}
	
	//Implementing list category methods
	//listCategory method, which is invoked by LISTCategoryservlet class
	public void listCategory(String message) throws ServletException, IOException {
		
	//category services calls the listAll() method in CategoryDAO
	//listAll returns all the category objects 
	List<Category> lstCategory	= categoryDAO.listAll();
	
	//adding the list Cate object to the request attribute 
	request .setAttribute("listCategories", lstCategory);
	//successful category creation message
	
	if (message != null) { 
	request.setAttribute("message", message);
	}
	
	//forwading the request to the listCategory JSP page
	String listPage = "category_list.jsp";
	RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
	
	requestDispatcher.forward(request, response);
		
	}
	
	//listCategory() method doesnt have any parameter, therefore it simply delegates the call to another overload
	
	public void listCategory() 
			throws ServletException, IOException {
		listCategory(null); //no parameter
	
	}
	
	
	public void createCategory() 
			throws ServletException, IOException {
		
		//checking the existence of a category with a given name 
		String name = request.getParameter("name");
		Category existCategory = categoryDAO.findByName(name);
		
		
		//error message if category exists
		
		if (existCategory != null) {
			String message = "Category could not be created. "
					+ " Category with name : " + name + " already exists.";
			//set message to request attribute
			request.setAttribute("message",  message);
			//forward to the message.jsp page using requestDispatcher
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
	
					
		} 
		else {
			Category newCate = new Category(name);
			categoryDAO.create(newCate);
			String message = "A new category has been successfully created";
			request.setAttribute("message",  message);
			
			//refresh the list page with successful message
			listCategory(message);
			
		}
					
	}
	
	
	public void editCategory() throws ServletException, IOException	 {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		//calling the categoryDAO get method that returns the category object from database
		Category category = categoryDAO.get(categoryId);
		//setting the catgory object to the request attribute
		request.setAttribute("category", category);
		
		String editPage = "category_form.jsp";
		//forwarding the request to the catgory form page 
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
		
	}
	
	public void updateCategory() throws ServletException, IOException {
		int categoryIdd = Integer.parseInt(request.getParameter("id"));
		String categoryName = request.getParameter("name");
		
		
		//need to check if the categoryName exists or not 
		Category categoryById = categoryDAO.get(categoryIdd);
		Category categoryByName = categoryDAO.findByName(categoryName);
		
		//if the name exists and admin is trying to update the category to a name that already exists in the database
		if (categoryByName != null && categoryById.getCategoryId() != categoryByName.getCategoryId()) {
			
			String message = "Category with name " + categoryName + 
					" already exists in the database. Please choose another name!";
			
			request.setAttribute("message", message );
			
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
		requestDispatcher.forward(request, response);
					
		} else { //update the category Name
			categoryById.setName(categoryName);
			categoryDAO.update(categoryById);
			String message = "The category has been successfully updated";
			listCategory(message);
			
			
				} 		
	
		}

	public void deleteCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		categoryDAO.delete(categoryId);

		String message = "The category with ID " + categoryId + " has been successfully deleted";
		listCategory(message);
		
	}
	
}
	
	
	
	
	


