package myCertification.bank.controller;

import java.io.IOException;
import java.util.Date;

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

public class SaveTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TransactionService transactionService;

	public void init(ServletConfig config) throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("transaction-beans.xml");
		transactionService = (TransactionService) context.getBean("transaction-service");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO: Logic to create the account

		try {
			Date today = new Date();
			HttpSession session = request.getSession();
			long userId = (long) session.getAttribute("id");
			String amt = request.getParameter("amt");
			long amount = Long.parseLong(amt);

			if (request.getParameter("credit") != null) {

				String acc_to = request.getParameter("acc");
				long acc_to_long = Long.parseLong(acc_to);
				String description = "Credit";

				Transaction tx = new Transaction(today, description, amount, acc_to_long, userId);

				transactionService.saveCredit(tx);

			}
			if (request.getParameter("debit") != null) {

				String acc_to = request.getParameter("acc");
				long acc_from_long = Long.parseLong(acc_to);
				String description = "Debit";

				Transaction tx = new Transaction(today, description, amount, acc_from_long, userId);

				transactionService.saveDebit(tx);

			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
