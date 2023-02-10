package myCertification.bank.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import myCertification.bank.dto.CreditCard;
import myCertification.bank.services.CreditCardService;

public class AuthorizeCreditCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CreditCardService creditCardService;

	ApplicationContext context;

	public void init(ServletConfig config) throws ServletException {
		context = new ClassPathXmlApplicationContext("cc-beans.xml");
		creditCardService = (CreditCardService) context.getBean("auth-cc");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String credit_card = request.getParameter("ccnum");
			long cc_to_long = Long.parseLong(credit_card);
			String cvv = request.getParameter("cvv");
			long cvv_to_long = Long.parseLong(cvv);
			String amt = request.getParameter("amt");
			long amount = Long.parseLong(amt);

			CreditCard validNumber = creditCardService.findCardByNumber(cc_to_long, cvv_to_long);

			if (validNumber != null) {

				if (amount > 100000) {
					response.sendRedirect("auth-denied.jsp");
				} else {
					CreditCard cc = new CreditCard(cc_to_long, cvv_to_long, amount);
					creditCardService.authorizeCreditCard(cc);
					response.sendRedirect("auth-success.jsp");
				}
			} else {
				response.sendRedirect("cc-not-valid.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
		((ClassPathXmlApplicationContext) context).close();
	}

}