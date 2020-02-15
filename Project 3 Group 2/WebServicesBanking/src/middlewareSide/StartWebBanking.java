package middlewareSide;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import DataBase.*;
// import transactions.*;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Servlet implementation class StartWebBanking
 */
@WebServlet("/StartWebBanking")
public class StartWebBanking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartWebBanking() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Gte the values from the incoming request

		int acc = 0;
		int trans = 0;
		boolean success = false;

		AccountEntry theTransactionResult = null;
		
		/*PROJECT3 ITEC 4020 START
		 * GET A HANDLER FOR THE SERVICE IN TWO STEPS
		 * a) create a service object ExposedBankingWebServiceImplService service = ....
		 * b) get a service handler  xposedBankingWebService theServiceHandler = ... 
		 *    using the service object created in a)
		 */

		// ADD CODE HERE	
		ExposedBankingWebServiceImplService service = new ExposedBankingWebServiceImplService();
		ExposedBankingWebService theServiceHandler = service.getExposedBankingWebServiceImplPort();
		/*PROJECT3 ITEC 4020 END
		

		/*
		 * here we get the values form the previous Servlets by examining the
		 * corresponding attributes we have set in the Session passed through the
		 * request parameter. See the setting of this attributes and their values at the
		 * Login, Welcome, and TransactionDetails servlets. These attributes are passed
		 * from servlet to servlet via the request parameter of the doGet method.
		 */

		String value = request.getParameter("amountValue");
		String userName = (String) request.getSession().getAttribute("uname");
		String thePin = (String) request.getSession().getAttribute("upass");
		String accType = (String) request.getSession().getAttribute("accType");
		String transType = (String) request.getSession().getAttribute("transType");
		Boolean proceed = (Boolean) request.getSession().getAttribute("proceed");
		String accTypeSpecifier = "";

		/*
		 * ITEC 4020 Remember that the card number servers as a user's user name and the
		 * pin as its password. As these are collected as strings we convert them to
		 * integers.
		 */
		int cardNo = Integer.parseInt(userName);
		int pin = Integer.parseInt(thePin);
		int amount = Integer.parseInt(value);

		/*
		 * ITEC 4020 Remember here we have set the proceed attribute to true so it will
		 * go through. When we finish we set it to false so one can not re-invoke the
		 * the servlet's operation without going first through the previous servlet.
		 */
		if (proceed) {

			if (accType.equals("Chequing")) {
				accTypeSpecifier = "Chequing";
				acc = 1;

			}

			if (accType.equals("Savings")) {
				accTypeSpecifier = "Savings";
				acc = 2;
			}

			if (transType.equals("Withdrawal")) {
				trans = 1;

				/*PROJECT3 ITEC 4020 START */

				/*
				 * PROJECT 3 ITEC 4020 Call the performDBWithdrawal operation on the handler theServiceHandler
				 * and set the result in  the theTransactionResult object
				 */
			         
				// ADD CODE HERE
				theTransactionResult = theServiceHandler.performDBWithdrawal(cardNo, pin, acc, amount);
				/*PROJECT3 ITEC 4020 END */
				
				success = true;

				NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.CANADA);

				theTransactionResult
						.setDisplayedBalance((String) currencyFormat.format(theTransactionResult.getBalance()));


			};

			if (transType.equals("Deposit")) {
				trans = 2;

				
				/*PROJECT3 ITEC 4020 START */
				/*
				 * PROJECT 3 ITEC 4020 Call the performDBDeposit operation on the handler theServiceHandler
				 * and set the result in  the theTransactionResul object
				 * Use the same arguments as in your previous projects
				 */
			         
				// ADD CODE HERE	
				theTransactionResult = theServiceHandler.performDBDeposit(cardNo, pin, acc, amount);
				/*PROJECT3 ITEC 4020 END */
			
				success = true;

				/*
				 * ITEC 4020 Here we use a Java library to convert an integer to currency
				 * Canadian dollars here
				 */

				NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.CANADA);

				theTransactionResult
						.setDisplayedBalance((String) currencyFormat.format(theTransactionResult.getBalance()));


			}

			/*
			 * Here we set the proceed attribute back to false
			 */

			request.getSession().setAttribute("proceed", false);

			if (success) {

				request.getSession().setAttribute("ResultsBean", theTransactionResult);
				request.setAttribute("ResultsBean", theTransactionResult);
				
				/*PROJECT3 ITEC 4020 START */
				
				// PROJECT 3 pass the control to a JSP with path "/ShowResults1.jsp" (see lecture notes week 4 p41)

				// ADD REDIRECTION HERE 
				getServletConfig().getServletContext().
                getRequestDispatcher( "/ShowResults1.jsp").
                forward(request, response);
				/*PROJECT3 ITEC 4020 END */

			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
