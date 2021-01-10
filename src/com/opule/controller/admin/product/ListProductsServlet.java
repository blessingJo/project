package com.opule.controller.admin.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.controller.frontend.HomeServlet;
import com.opule.service.ProductServices;

/**
 * Servlet implementation class ListProductsServlet
 */
@WebServlet("/admin/list_products")
public class ListProductsServlet extends HomeServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//instance of productServices class
		ProductServices productServices = new ProductServices(entityManager, request, response);
		//calling listProducts method of productServices
		productServices.listProducts();
	} 

}
