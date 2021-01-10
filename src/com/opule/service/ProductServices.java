package com.opule.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.dao.CategoryDAO;
import com.opule.dao.ProductDAO;
import com.opule.entity.Product;

public class ProductServices {
	private EntityManager entityManager;
	private ProductDAO productDAO;
	//CategoryDAO class requires an entity Manager from EMF
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	//list book method
	public void listBooks() {
		
		
		
	}

	public ProductServices(EntityManager entityManager, HttpServletRequest request,
			HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		//this.categoryDAO = categoryDAO;
		this.request = request;
		this.response = response;
		productDAO = new ProductDAO(entityManager);
	}

	public void listProducts() throws ServletException, IOException {
		
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

}
