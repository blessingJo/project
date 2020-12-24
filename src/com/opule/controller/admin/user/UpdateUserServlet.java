package com.opule.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.controller.BasisServlet;
import com.opule.service.UserServices;


@WebServlet("/admin/update_user") //local host extension

public class UpdateUserServlet extends BasisServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateUserServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		//new instance of userServices for updateUser
		UserServices userServices = new UserServices(entityManager, request,response);
		userServices.updateUser();
		
	}

}
