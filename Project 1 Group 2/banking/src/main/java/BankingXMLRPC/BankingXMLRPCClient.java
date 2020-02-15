package BankingXMLRPC;

import java.net.URL;
import java.util.Vector;
import java.util.Scanner;

import org.apache.xmlrpc.XmlRpcClient;

public class BankingXMLRPCClient {

	public static void main(String[] args) {
		
		try {	
			// create a configuration instance with the requested URL
	  
			XmlRpcClient client = new XmlRpcClient(new URL("http://localhost/RPC2"));
			
			BankingXMLRPCInputReader aReader = new BankingXMLRPCInputReader();
			
	

	      //   Vector<Integer> params = new Vector<Integer>();
			
			 int choice = -1;
	         
	         Scanner input = new Scanner(System.in);
	         while (choice != 0) {
		         System.out.print("Enter an operation (1) for withdrawal or (2) for deposit  or (0) to stop: ");
		     	 choice = input.nextInt();
		     	 System.out.print("\n ");
		     	 
		     	 if (choice != 0) {
		     		 // get the data from the user
		     		Vector<Integer> params  = aReader.getUserInput();
		     		// add as first parameter the choice so the server would know whether to perform 
		     		// withdrawal or deposit
		     		params.insertElementAt(new Integer(choice), 0);
		     		// make the call to the service using the execute method
			
				// ITEC_4020: ADD CODE HERE
		     		client.execute("serviceHandler.ExecuteService", params);
			 }
		     	 
	         
	         }

	      //   int sum = ((Integer) result).intValue();
	       //  System.out.println("The sum is: "+ sum);

	      } catch (Exception exception) {
	         System.err.println("JavaClient: " + exception);
	      }
		}
	   }

