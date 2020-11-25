package com.opule.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.service.UserServices;

@WebServlet("/admin/edit_user")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditUserServlet() {
        super();
        }

	//Servlet invokes the editUser method of of the userServices class

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserServices userServices = new UserServices(request,response);
	userServices.editUser();
	}
	
	
	
	

	
}
