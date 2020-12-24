package com.opule.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.controller.BasisServlet;
import com.opule.service.UserServices;

@WebServlet("/admin/delete_user") //local host extension
public class DeleteUserServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteUserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//new instant of the userServices class
		UserServices userServices = new UserServices( entityManager, request , response );
		userServices.deleteUser();
	
		
		
	}


}
