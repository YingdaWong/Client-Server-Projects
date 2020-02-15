package BankingRMI;

import java.io.DataOutputStream;
import java.util.Scanner;
import java.util.Vector;

public class BankingRMIInputReader {
	
	public Vector<Integer> getUserInput() {
		
	 	Vector<Integer> params = new Vector<Integer>();
	 
     	Scanner input = new Scanner(System.in);
   
     	
	 	System.out.print("Enter cardNo: ");
	    int cardNo = input.nextInt();
	    System.out.print("\n ");
	     	 
	    System.out.print("Enter pin: ");
	    int pin = input.nextInt();
	    System.out.print("\n ");     
	     	 
	    System.out.print("Enter account: ");
	    int account = input.nextInt();
	    System.out.print("\n ");
	     	 
	     	 
	    System.out.print("Enter amount: ");
	    int amount = input.nextInt();
	    System.out.print("\n ");
	     	 
	    
	    params.addElement(new Integer(cardNo));
	    params.addElement(new Integer(pin));
	    params.addElement(new Integer(account));
	    params.addElement(new Integer(amount));
     	 
     
	        
	    return params;
	}
	
	
}
