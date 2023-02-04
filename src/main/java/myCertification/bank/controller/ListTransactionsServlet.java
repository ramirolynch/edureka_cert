package myCertification.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myCertification.bank.dto.Transaction;
import myCertification.bank.services.TransactionService;

public class ListTransactionsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TransactionService transactionService;
	
	ApplicationContext context;

	public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("transaction-beans.xml");
		transactionService = (TransactionService) context.getBean("transaction-service");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO: Logic to create the account

		try {
			HttpSession session = request.getSession();
			long userId = (long) session.getAttribute("id");
			List<Transaction> transactions = transactionService.findAllTransactionsByUserId(userId);
			request.setAttribute("transactions", transactions);
			request.getRequestDispatcher("transactions.jsp").forward(request, response);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void destroy() {
	    ((ClassPathXmlApplicationContext)context).close();
	}

}
