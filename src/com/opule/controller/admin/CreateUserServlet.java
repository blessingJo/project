package com.opule.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.service.UserServices;


@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//invoked when user/admin clicks the 'save button'
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//calling create user method in userServices
		UserServices userServices = new UserServices(request, response);
		userServices.createUser();
		//request, response
		//Refreshing the user list page after successfully creating a new user by calling the listUser method
		userServices.listUser("New user created successfully!");
		
		
		

	} 

}
