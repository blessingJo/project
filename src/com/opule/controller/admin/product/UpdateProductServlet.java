package com.opule.controller.admin.product;

import com.opule.controller.BasisServlet;
import com.opule.service.ProductServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/update_product")
@MultipartConfig( //configurations for the request
		//fileSizethreshold - if the greater than this size it'll be stored on disk rather than memory
		fileSizeThreshold = 1024 * 10, //10 KB
		maxFileSize = 1024 * 300, //300KB
		maxRequestSize = 1024 * 1024 //includes image data and values of other form fields 1MG
		)
public class UpdateProductServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;

   
    public UpdateProductServlet() {
    	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ProductServices productServices = new ProductServices(entityManager, request, response);
		productServices.updateProduct();
		
		
		
	}

}
