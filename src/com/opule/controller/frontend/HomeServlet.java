package com.opule.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.controller.BasisServlet;
import com.opule.dao.CategoryDAO;
import com.opule.entity.Category;


@WebServlet("") //indication that this is java servlet
public class HomeServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;
       
 
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    	//doGet forwards the request to the home page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//need to retrieve list of categories from categoryDAO
			CategoryDAO categoryDao = new CategoryDAO(entityManager);
			List<Category> categoryList = categoryDao.listAll();
		//set the list object to the request attribute 
			request.setAttribute("listCategory", categoryList);
			
			String homepage = "frontend/index.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
			dispatcher.forward(request, response);		
	}
	
	//need to retrieve list of categories from categoryDAO
	

	

}
