package com.opule.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.controller.admin.BasisServlet;
import com.opule.service.UserServices;

//Edit user servlet
@WebServlet("/admin/edit_user")// local host extension
public class EditUserServlet extends BasisServlet {
	
	private static final long serialVersionUID = 1L;
       

    public EditUserServlet() {
        super();
        }

	//Servlet invokes the editUser method of of the userServices class

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserServices userServices = new UserServices(entityManager, request,response);
		userServices.editUser();
	}
	
	
	
	

	
}
