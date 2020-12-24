package com.opule.controller.admin.category;

import com.opule.controller.BasisServlet;
import com.opule.service.CategoryServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/update_category")
public class UpdateCategoryServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;


    public UpdateCategoryServlet() {
        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//calling the updateCATEGORY method of CategoryServices class
		CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
		categoryServices.updateCategory(); //$
	}

}
