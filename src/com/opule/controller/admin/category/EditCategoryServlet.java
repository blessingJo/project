package com.opule.controller.admin.category;

import com.opule.controller.BasisServlet;
import com.opule.service.CategoryServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/edit_category")
public class EditCategoryServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;


    public EditCategoryServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		//instance of the category services class
		CategoryServices categoryService = new CategoryServices(entityManager, request, response);
		categoryService.editCategory();
	
	}
	
	

}
