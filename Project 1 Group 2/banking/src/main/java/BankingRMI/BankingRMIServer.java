package BankingRMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

//import rmi.examples.MyService1;
//import rmi.examples.MyService2;
//import transactions.Deposit;
//import transactions.Withdrawal;

public class BankingRMIServer {

public static void main(String[] args){
		
		try {
			LocateRegistry.createRegistry(6600);
			// i.e .rebind the services that is a BankingRMIWithdrawalService and the BankingRMIDepositService
			// use the same idea as your examples
			
            
			// ITEC_4020: ADD CODE HERE BankingRMIWithdrawalService
		       
			Naming.rebind("//localhost:6600/WithdrawalServer", new BankingRMIWithdrawalService()); 
			System.err.println("Withdrawal Server ready");
            
			// ITEC_4020: ADD CODE HERE
			
			Naming.rebind("//localhost:6600/DepositServer", new BankingRMIDepositService());
		    System.err.println("Deposit Server ready");
            
        } catch (Exception e) {
        	System.err.println("Server exception: " + e.toString());
          e.printStackTrace();
        }
	}

}
