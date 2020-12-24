package com.opule.controller.admin.category;

import com.opule.controller.BasisServlet;
import com.opule.service.CategoryServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/delete_category")
public class DeleteCategoryServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCategoryServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
	categoryServices.deleteCategory();
	}
	

}
