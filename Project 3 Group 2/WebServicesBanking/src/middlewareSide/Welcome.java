package middlewareSide;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*****************************************************************
 * Servlet implementation class Welcome
 * This is the servlet class that collects information on what account 
 * is to be used (Savings or Checking) and what operation (Withdrawal 
 * or Deposit). The colelction is through a form. 
 * ****************************************************************
 */

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{ 
			/*
			 * ITEC 4020 We create the Content type and we create a writer
			 */
			  response.setContentType("text/html");
		      PrintWriter pwriter = response.getWriter();
		      
		      /*
		       * ITEC 4020  Here we obtain the session (given the incoming request) and
		       * we set two attributes "uname" and "upass". Then we give as values to 
		       * attributes the values of username and userPassword fields that come
		       * through the incoming request. See the Login servlet's form for these
		       * values being set
		       */
		      
				HttpSession session=request.getSession();
				session.setAttribute("uname", request.getParameter("userName"));
				session.setAttribute("upass",request.getParameter("userPassword"));
				
				/*
				 * ITEC 4020 Here we create the form content, and set as its action to
				 * be a call to the TransactionsDetails servlet.
				 */

		      pwriter.print("<form action=\"TransactionDetails\">"
		    		        + "Savings Account <input type=\"radio\" name=\"accountType\" value = \"Savings\"/><br/>"
		    		        + "Chequing Account <input type=\"radio\" name=\"accountType\" value = \"Chequing\"/><br/>"
		    		        + "Deposit <input type=\"radio\" name=\"transactionType\" value = \"Deposit\"/><br/>"
		    		        + "Withdrawal <input type=\"radio\" name=\"transactionType\" value = \"Withdrawal\"/><br/>"
		    		        + "<input type=\"submit\" value=\"submit\"/> </form>");
		      pwriter.close();
		    }catch(Exception exp){
			      System.out.println(exp); 
		   }
			
	}	
		
	
		//      String name = request.getParameter("userName");
		//      String password = request.getParameter("userPassword");
		//      pwriter.print("Hello "+name);
		//      pwriter.print("Your Password is: "+password);
		//      HttpSession session=request.getSession();
		//      session.setAttribute("uname",name);
		//      session.setAttribute("upass",password);
		//      pwriter.print("<a href='StartWebBanking'>view details</a>");
		//      pwriter.close();
		//    }catch(Exception exp){
		//       System.out.println(exp); 
		//    }

        //	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
