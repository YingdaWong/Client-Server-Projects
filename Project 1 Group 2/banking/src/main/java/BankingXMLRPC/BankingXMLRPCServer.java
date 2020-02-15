package BankingXMLRPC;

import java.util.Vector;

import org.apache.xmlrpc.WebServer;

import transactions.Deposit;
import transactions.Withdrawal;
import transactions.exceptions.DailyLimitExceededException;
import transactions.exceptions.InsufficientBalanceException;
import transactions.exceptions.InvalidAccountTypeException;
import transactions.exceptions.InvalidCredentialsException;

public class BankingXMLRPCServer {

	public Integer ExecuteService(int choice, int cardNo, int pin, int account, int amount) throws InvalidAccountTypeException, DailyLimitExceededException, InsufficientBalanceException, InvalidCredentialsException{
		//  System.out.println("HERE WE CALL SOMETHING WITH PARAMS " + choice + " " + cardNo + " " + pin + " " + account + " " + amount + " ");
	      
	      
	      if (choice == 1){
	    	// if choice  is equal 1 is a withdrawal 
	    	
		// call the service using its perform method (see the transactions package)
		// after you create the right object (i.e. Withdrawal)
			// ITEC_4020: ADD CODE HERE
	    	Withdrawal w = new Withdrawal();
	    	w.perform(cardNo, pin, account, (double)amount);
	      }
	    	  
	      if (choice == 2) {
	    	 // if choice  is equal 2 is a deposit 
	    	
		// call the service using its perform method (see the transactions package)
		// after you create the right object (i.e. Deposit)
			// ITEC_4020: ADD CODE HERE
	    	Deposit d = new Deposit();
	    	d.perform(cardNo, pin, account, (double)amount);
	      }
	      
		  return new Integer(1);
	}
	
	
	public static void main(String[] args) {
		try {

	         System.out.println("Attempting to start XML-RPC Server...");
	         
	         WebServer server = new WebServer(80);
	         server.addHandler("serviceHandler", new BankingXMLRPCServer());
	         
	         server.start();
	         
	         System.out.println("Started successfully.");
	         System.out.println("Accepting requests. (Halt program to stop.)");
	         
	      } catch (Exception exception){
	         System.err.println("JavaServer: " + exception);
	      }
	   }

	}
