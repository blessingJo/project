package com.opule.controller.admin.product;

import com.opule.controller.BasisServlet;
import com.opule.service.ProductServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/delete_product")
public class DeleteProductServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;

   
    public DeleteProductServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	ProductServices productServices = new ProductServices(entityManager, request, response);
	productServices.deleteProduct();
	
	
	}

}
