package myCertification.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myCertification.bank.dto.User;
import myCertification.bank.services.UserService;


public class SearchUserServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	private UserService userService;
	public void init(ServletConfig config) throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("bank-beans.xml");
		userService = (UserService) context.getBean("bank-service");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();  
		
		String inputValue = request.getParameter("id");
		Long intValue = Long.parseLong(inputValue);
		session.setAttribute("id",intValue);  
		String pass = request.getParameter("password");		
		
		System.out.println("id number is " + intValue);
				
		User user = userService.findUserById(intValue);
		
		if(user != null) {
			if(pass.equalsIgnoreCase(user.getPassword())) {
				response.sendRedirect("home.jsp");
			}
			out.println("user is not null");
		}
		else {
			//TODO: redirect to an account doesn't exist
			out.println("user is null");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
