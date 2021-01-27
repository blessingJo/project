package com.opule.controller.admin.product;

import com.opule.controller.BasisServlet;
import com.opule.service.ProductServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/edit_product")
@MultipartConfig( //configurations for the request
		fileSizeThreshold = 1024 * 10, //10 KB
		maxFileSize = 1024 * 300, //300KB
		maxRequestSize = 1024 * 102
		)
public class EditProductServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;

    public EditProductServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductServices productServices = new ProductServices(entityManager, request, response);
		productServices.editProduct(); 
	}
	

}
