package com.opule.controller.admin.product;

import com.opule.controller.frontend.HomeServlet;
import com.opule.service.ProductServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductFormServlet
 */
@WebServlet("/admin/product_FormNew")
public class ProductFormServlet extends HomeServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HomeServlet#HomeServlet()
     */
    public ProductFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//instance of productServices class
		ProductServices productServices = new ProductServices(entityManager, request, response);
		//calling newProductForm method of productServices
		productServices.newProductForm();
	}

}
