package myCertification.bank.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import myCertification.bank.dto.Account;
import myCertification.bank.services.AccountService;

public class CreateAccountServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private AccountService accountService;
	
	public void init(ServletConfig config) throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("account-beans.xml");
		accountService = (AccountService) context.getBean("acc-service");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO: Logic to create the account
		
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");	
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date dob1 = null;
		try {
			dob1 = formatter.parse(dob);
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String accounttype = request.getParameter("accounttype");
			HttpSession session=request.getSession();
			long userId = (long) session.getAttribute("id");

		    Account acc = new Account(name,dob1,address,email,accounttype, userId);
		    accountService.saveAccount(acc);
		
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
