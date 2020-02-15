package BankingSockets;
import java.net.*;
import java.util.Scanner;
import java.io.*; 


public class BankingSocketsClient {

		
		private Socket socket = null; 
		private DataOutputStream out = null; 
		
	
	

		public BankingSocketsClient(String address, int port) { 
			
			String message = "";
			int choice = -1;
		    Scanner input = new Scanner(System.in);
		    
		    
			// establish a connection 
			try { 
				socket = new Socket(address, port); 
				
				// ITEC_4020: ADD CODE HERE
				out = new DataOutputStream(socket.getOutputStream());
			} 
			catch(UnknownHostException u) { 
				System.out.println(u); 
			} 
			catch(IOException i) { 
				System.out.println(i); 
			} 

			// string to read message from input 
			BankingSocketsInputReader aReader = new BankingSocketsInputReader();


			// keep reading until "0" is input 
			
				while (choice != 0) {
					 message = "";
			         System.out.print("Enter an operation (1) for withdrawal or (2) for deposit  or (0) to stop: ");
			     	 choice = input.nextInt();
			     	 
				     if (choice  == 0)
				     	 message = message + Integer.toString(choice);
			     	 
			     	 if (choice != 0) {
			     		message = Integer.toString(choice) + " " + aReader.getUserInput() +"\n";
			     	 }
				         
					try {
                                                // Send the message
						// ITEC_4020: ADD CODE HERE
						out.writeUTF(message);

						
						} catch (IOException e) {
						e.printStackTrace(); 
						}
				}
				         

			// close the connection 
			try { 
				out.close(); 
				socket.close(); 
			} 
			catch(IOException i) { 
				System.out.println(i); 
			} 
		} 

		
		
		public static void main(String args[]) { 
			BankingSocketsClient client = new BankingSocketsClient("127.0.0.1", 5001); 
		} 
	} 

	

