package com.opule.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//abstract class, super class & can't be instantiated 
//superclass that contains all the common fields/code for the subclasses


@WebServlet("/")
public class BasisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//declare EntityManager & EntityManagerFactory
	//private (protected) so it can be inherited by subclasses
	
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	
	
	//lifecycle method of the service class init() + destroy() 
	
	@Override
	public void init() throws ServletException {
		//instances of the entityManagerFactroy and EM initialized
		//init() method is called when the servlet class is first created
		entityManagerFactory = Persistence.createEntityManagerFactory("OpuleWebsite");
		entityManager = entityManagerFactory.createEntityManager();
	} 
	
	//called when the servlet is destroyed, releasing EMF and EM
	@Override
	public void destroy() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
	
	
	
	

}
