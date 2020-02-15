package middlewareSide;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the Servlet implementation class Login
 * This is the initial Servlet class that drives the whole application 
 * project (the parts that deal with servlets, and JDBC excluding 
 * Jersey
 * This servlet calls upon hitting the Submit button, calls the 
 * Welcome servlet. This Login servlet  collects the the bank card number 
 * (which serves as the customer's user name), and the bank card pin
 * (which serves as the customer's password).
 * ****************************************************************
 */


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * ITEC 4020 Here is the doGet methid of the Login servlet
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{ 
			  /* 
			   * ITEC 4020 here we set the contejt type and we create a writer
			   * to add the conents of the form 
			   */
		      response.setContentType("text/html");
		      PrintWriter pwriter = response.getWriter();
		      
		      /*
		       * ITEC 4020 here we define the form and we set its action to be 
		       * a call to the servlet "Welcome"
		       */
		      

		      pwriter.print("<head><title>" + "WELCOME TO ITEC 4020 BANK" + "</title></head>\n" +
			            "<body bgcolor = \"#f0f0f0\">\n" +
			               "<h1 align = \"center\">" + "WELCOME TO ITEC 4020 BANK" + "</h1>\n"
		            + "</title></head>\n\n" 
		      		+ "<form action=\"Welcome\">"
		    		        + "User Name:<input type=\"text\" name=\"userName\"/><br/>"
		    		        + "Password:<input type=\"password\" name=\"userPassword\"/><br/>"
		    		        + "<input type=\"submit\" value=\"submit\"/> </form>");
		      pwriter.close();
		    }catch(Exception exp){
		       System.out.println(exp); 
		    }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * ITEC 4020 Here is the DoPost method. For our example it does nothing.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
