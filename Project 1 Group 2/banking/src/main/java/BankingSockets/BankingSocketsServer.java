package BankingSockets;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.StringTokenizer;

import transactions.Deposit;
import transactions.Withdrawal;
import transactions.exceptions.DailyLimitExceededException;
import transactions.exceptions.InsufficientBalanceException;
import transactions.exceptions.InvalidAccountTypeException;
import transactions.exceptions.InvalidCredentialsException;
import transactions.exceptions.InvalidTransactionException;

import java.util.*;

//import socket.examples.MyServer; 

public class BankingSocketsServer {
	
	private Socket		 socket = null; 
	private ServerSocket server = null; 
	private DataInputStream in	 = null; 
	
	// constructor with port 
	public BankingSocketsServer(int port) throws InvalidTransactionException { 
		// starts server and waits for a connection 
		try { 
			
			Deposit aDeposit;
			Withdrawal aWithdrawal;
			int choice = 0;
			
			Vector<String> callParameters = new Vector<String>(); 
			UserInputTokenizer aTokenizer = new UserInputTokenizer();
			
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 

			socket = server.accept(); 
			System.out.println("Client accepted"); 
			
			
			
			String line = "";  

			// takes input from the client socket 
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			try { 
				// read the incoming data 
				// ITEC_4020: ADD CODE HERE
				line = in.readUTF();

				} 
			catch(IOException i) { 
			    System.out.println(i); 
			    }

			if (line.equals("0"))
				choice = 0;
			
			while (!line.equals("0")) { 
				    
				   callParameters =  aTokenizer.tokenizeInput(line);
				   

					if(callParameters.get(0).equals("1"))
						 	choice = 1;
					if (callParameters.get(0).equals("2"))
							choice = 2;

					switch (choice) {
							case 0: 
							    System.out.println("Exiting");
						    case 1: 
						    	    // if choice is equal 1 then it is a withdrawal
									aWithdrawal = new Withdrawal();
									try {
										// call the service using its perform method (see the transactions package)
										// // ITEC_4020: ADD CODE HERE
										aWithdrawal.perform(Integer.parseInt(callParameters.get(1)),Integer.parseInt(callParameters.get(2)),Integer.parseInt(callParameters.get(3)),Double.parseDouble(callParameters.get(4)));
																
									        } catch (InvalidAccountTypeException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (DailyLimitExceededException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (InsufficientBalanceException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (InvalidCredentialsException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									break;
							case 2:
								// if choice is equal 2 then it is a deposit
									aDeposit = new Deposit();
									try {
										// call the service using its perform method (see the transactions package)
										// ITEC_4020: ADD CODE HERE
										aDeposit.perform(Integer.parseInt(callParameters.get(1)),Integer.parseInt(callParameters.get(2)),Integer.parseInt(callParameters.get(3)),Double.parseDouble(callParameters.get(4)));

										} catch (InvalidAccountTypeException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (DailyLimitExceededException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (InsufficientBalanceException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (InvalidCredentialsException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									break;
							default:
								    System.out.println("Transaction not performed");
								    	
							    }
					
							// Clear the vector wih call parameters to be ready for 
							// the next invocation
							callParameters.clear();
						    // Block server and wait for new input from client
							line = in.readUTF();				

						}
						System.out.println("Closing connection"); 

						// close connection 
						socket.close(); 
						in.close(); 
					} 
					catch(IOException i) { 
						System.out.println(i); 
					} 
				} 

	
	
				public static void main(String args[]) throws InvalidTransactionException { 
					
					   BankingSocketsServer server = new BankingSocketsServer(5001); 

					 
				} 
			} 


