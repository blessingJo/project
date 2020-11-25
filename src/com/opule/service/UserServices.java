package com.opule.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opule.dao.UserDAO;
import com.opule.entity.Users;

public class UserServices {
	//uses UserDAO class
	private UserDAO userDAO;
	//UserDAO class requires an entity Manager from EMF
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private Users user;
	
	
	
	public UserServices(HttpServletRequest request, HttpServletResponse response) { //constructor for superclass 
		this.request = request;
		this.response = response;
		entityManagerFactory = Persistence.createEntityManagerFactory("OpuleWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO  = new UserDAO(entityManager);
		
	}

	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	public void listUser(String message) 
		throws ServletException, IOException {
		//call method that returns all 'listAll' objects
		List<Users> listUsers = userDAO.listAll();
				//request to send the users list to the jsp page
		request.setAttribute("listUsers", listUsers);
		
		//sending successful message to userlist jsp page
		if (message !=null ) {
		request.setAttribute("message", message);
		}
				
		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		
		requestDispatcher.forward(request, response);
	
	}
	
		
	//method to save create user data in database
	
	public void createUser() throws ServletException, IOException {
		//method invoked by UserServices class
		
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");	
		
		Users userExists = userDAO.findByEmail(email);
		
		if(userExists != null ) {
		//redirect user to a message page using requestDispatcher
			String message  = "User could not be created. A user with email " + email + " already exists";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
			
			
		}
		
		else {
			Users newUser = new Users(email, fullName, password);
			userDAO.create(newUser);
			}

	}

		public void editUser() throws ServletException, IOException {
			//invokes the get(userid) in userDAO method to retrieve the details of the selected user (ID number)
			//user ID is retreived from the the url parameter
			int userID = Integer.parseInt(request.getParameter("id"));
			Users user =userDAO.get(userID);
			
			String editPage = "user_form.jsp";
			//setting the attribute in the request to store the retrieved user object
			request.setAttribute("user", user);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
			requestDispatcher.forward(request, response);
		
	}

		public void updateUser() throws ServletException, IOException {
			//using the GET method to retrieve user information 
			int userId = Integer.parseInt(request.getParameter("userId"));
			String email = request.getParameter("email");
			String fullname = request.getParameter("fullname");
			String password = request.getParameter("password");
			
			//System.out.println(userId + ", " + email + ", " + fullname + ", " + password);

			//retrieving user info by using user ID
			Users userById = userDAO.get(userId);
			Users userByEmail = userDAO.findByEmail(email);
			
			if (userByEmail != null &&  userByEmail.getUserId() != userById.getUserId()) {
				String message = "User could not be updated. A user with email " + email + " already exists";
				request.setAttribute("message", message);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
				requestDispatcher.forward(request, response);
			
			}else {
		
			//creating a new user object to be updated 
			
			Users user = new Users(userId, email, fullname, password);
			userDAO.update(user); //calling the update method in userDAO
			
			//calling the listUser method to refresh the user list page
			
			String message = "User has been successfully updated";
			listUser(message);
			 
		}
		}

		public void deleteUser() throws ServletException, IOException {
			//obtaining the userId from the request parameter, name of parameter =id
			int userId = Integer.parseInt(request.getParameter("id"));
			//calling userDAO delete method
			userDAO.delete(userId);
			//calling listUser method to refresh the user list page
			String message = "User has been successfully deleted!";
			listUser(message);
			
		}

}