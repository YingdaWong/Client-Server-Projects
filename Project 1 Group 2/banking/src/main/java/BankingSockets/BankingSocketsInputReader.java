package BankingSockets;

import java.util.Scanner;
import java.net.*;
import java.io.*; 

public class BankingSocketsInputReader {

	private Scanner scanner = null;
	private DataOutputStream out	 = null; 
	
	public String getUserInput(){
		
		Scanner input = new Scanner(System.in);
		
		String userInput = "";

		// sends output to the socket 
		
		 System.out.print("Enter cardNo: ");
    	 int cardNo = input.nextInt();
    	// System.out.print("\n ");
    	 
        System.out.print("Enter pin: ");
    	 int pin = input.nextInt();
    	// System.out.print("\n ");     
    	 
        System.out.print("Enter account: ");
    	 int account = input.nextInt();
    	// System.out.print("\n ");
    	 
    	 
        System.out.print("Enter amount: ");
    	 int amount = input.nextInt();
    	// System.out.print("\n ");
    	 
    		userInput  = Integer.toString(cardNo) + " " + Integer.toString(pin) + " " + Integer.toString(account) + " " + Integer.toString(amount);
    	
		
		return userInput;
	}
	
}
