package com.opule.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.controller.admin.BasisServlet;
import com.opule.service.CategoryServices;


@WebServlet("/admin/list_category") //local host extension
public class ListCategoryServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListCategoryServlet() {
        
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("List Category ");
			
		//This servlet calls the listCategory() method in category services
		//entityManager is inherited from superclass :BasisServlet
		CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
		categoryServices.listCategory();
	}

}
