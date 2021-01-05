package com.opule.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.controller.BasisServlet;
import com.opule.service.UserServices;


@WebServlet("/admin/login")
public class AdminLoginServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;

	
	//do post method retrieves the vales of the parameters:email and password
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		UserServices userServices = new UserServices(entityManager, request, response);
		userServices.login();
	}

}
