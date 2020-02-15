package BankingRMI;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.Scanner;

import javax.swing.JOptionPane;

//import transactions.Deposit;
//import transactions.Withdrawal;



public class BankingRMIClient {
	
	
	private static BankingRMIWithdrawalInterface look_up_withdrawal;
	private static BankingRMIDepositInterface look_deposit;
	

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		look_up_withdrawal = (BankingRMIWithdrawalInterface) Naming.lookup("//localhost:6600/WithdrawalServer");
		//String txt = JOptionPane.showInputDialog("What is your name? (it will be passed to Service 1)");
		
		look_deposit = (BankingRMIDepositInterface) Naming.lookup("//localhost:6600/DepositServer");
		//String txt2 = JOptionPane.showInputDialog("What is your name2? (it will be passed to Service 2)");
	//	String txt3 = JOptionPane.showInputDialog("What is your surname? it will be passed to Service 2)");
		
		Vector<Integer> params = new Vector<Integer>();
        int choice = -1;
        double responseWithdrawal = -1.0;
        
        BankingRMIInputReader aReader = new BankingRMIInputReader();
        
		
        double responseDeposit = -1.0;
        
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
	         System.out.print("Enter an operation (1) for withdrawal or (2) for deposit  or (0) to stop: ");
	     	 choice = input.nextInt();
	     	 System.out.print("\n ");
	     	 
	     	 if (choice != 0) {
	     		 params = aReader.getUserInput();
	     		 params.insertElementAt(choice, 0);
	     		 
	     		 
			      if (params.get(0) == 1){
			    	// ITEC_4020: ADD CODE HERE
				// use the same idea as in your samples (hint use the doWithrawal method of of the BankingRMIWithdrawalService
			    	  responseWithdrawal = params.elementAt(4);
			    	  double result1 = look_up_withdrawal.doWithdrawal(params.elementAt(1), params.elementAt(2), params.elementAt(3), params.elementAt(4));
			    	  JOptionPane.showMessageDialog(null, "Withdrawal succeeded, new balance: "+result1+"\n"+"The amount is: "+responseWithdrawal);
			      }
			    	  
			      if (params.get(0) == 2) {
			    	// ITEC_4020: ADD CODE HERE
				// use the same idea as in your samples (hint use the doDeposit method of of the BankingRMIDepositService
			    	  responseDeposit = params.elementAt(4);
			    	  double result2 = look_deposit.doDeposit(params.elementAt(1), params.elementAt(2), params.elementAt(3), params.elementAt(4));
			    	  JOptionPane.showMessageDialog(null, "Deposit succeeded, new balance: "+result2+"/n"+"The amount is: "+responseDeposit);
			      }
	     	 }
        }
        input.close();
	}
}
		         


