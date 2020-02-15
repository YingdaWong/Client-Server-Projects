package transactions;



import transactions.exceptions.DailyLimitExceededException;
import transactions.exceptions.InsufficientBalanceException;
import transactions.exceptions.InvalidAccountTypeException;
import transactions.exceptions.InvalidCredentialsException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import BankingRMI.BankingRMIDepositInterface;



public class Deposit {
	
	public double perform(int cardNumber, int pin, int fromAccount, double amount) throws InvalidAccountTypeException,
			DailyLimitExceededException, InsufficientBalanceException, InvalidCredentialsException {

		System.out.println("Starting Deposit");
		if (!CredentialsChecker.checkCredentials(cardNumber, pin))
			throw new InvalidCredentialsException("Card number and PIN chosen do not match.");

		double balance = Accounts.getBalance(cardNumber, fromAccount);

		if (balance < 0.0)
			throw new InvalidAccountTypeException("Invalid account type");

		// Update withdrawals today and account balances once we know everything
		// is
		// OK
		System.out.println("Old Balance is " + balance);
		double newBalance = balance + amount;
		System.out.println("Updating balance");
		Accounts.setBalance(cardNumber, fromAccount, balance + amount);
		System.out.println("New Balance is " + newBalance);
		System.out.println("TERMINATING CURRENT DEPOSIT \n \n \n");

		// Return updated balances
		return newBalance;
	}
}
