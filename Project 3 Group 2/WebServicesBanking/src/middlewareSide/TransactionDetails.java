package middlewareSide;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransactionDetails
 * This servlet collects the amount to be deposited or withdrawn. 
 */
@WebServlet("/TransactionDetails")
public class TransactionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		int acc = 0;
		int trans = 0;
		/* ITEC 4020 The display text will change depending we have a withdrawal or a 
		 * deposit
		*/
		String displayText  = "";
		
		/* ITEC 4020 the proceed variable seves as a flag which will be added as 
		 * an attribute on the session.
		 * It will be set back to false when the next servlet StartWebBanking 
		 * The purpose for this session attribute is to prevent consequent invocations 
		 * of the servlet fromn  the browser to do new withdrawals of deposits.
		 * It is a good example of using sessions
		 */
		Boolean proceed = true;
		
		String accType = request.getParameter("accountType"); 
		String transType = request.getParameter("transactionType");

		
		// ITEC 4020 Add more attributes in the session
		
		request.getSession().setAttribute("accType", accType);
		request.getSession().setAttribute("transType",transType);
		request.getSession().setAttribute("proceed",proceed);
 
		if(accType.equals("Savings")) 
		{
			/*
			 * ITEC 4020 if the account is Savings the acc variable is set to 1
			 */
			acc = 1;
		}
		
		if(accType.equals("Chequing")) 
		{
			/*
			 * ITEC 4020 if the account is Chequing the acc variable is set to 2
			 */
			acc = 2;
		}
		
		if(transType.equals("Withdrawal")) 
		{
			/*
			 * ITEC 4020 if the operation is Withdrawal the trans variable is set to 1
			 */
		    trans = 1;
		    displayText = " to Withdraw ";
		}
		
		if(transType.equals("Deposit")) 
		{
			/*
			 * ITEC 4020 if the operation is Deposit the trans variable is set to 2
			 */
			trans = 2;
			displayText = " to Deposit ";
		}
		
		
		try{ 
			/*
			 * ITEC 4020 Set thhe content type of the form and create a writer.
			 */
		      response.setContentType("text/html");
		      PrintWriter pwriter = response.getWriter();
		      
		      /*
		       * ITEC 4020 Define the contents of the form and set its action to be to 
		       * call the StartWebBanking Servlet
		       */

		      pwriter.print("<form action=\"StartWebBanking\">"
		    		        + "Amount" + displayText + ":<input type=\"text\" name=\"amountValue\"/><br/>"
		    		        + "<input type=\"submit\" value=\"submit\"/> </form>");
		      pwriter.close();
		    }catch(Exception exp){
		       System.out.println(exp); 
		    }
		
		
		
	}

		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
