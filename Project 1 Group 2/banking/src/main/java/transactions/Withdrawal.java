package transactions;

import transactions.exceptions.DailyLimitExceededException;
import transactions.exceptions.InsufficientBalanceException;
import transactions.exceptions.InvalidAccountTypeException;
import transactions.exceptions.InvalidCredentialsException;

public class Withdrawal {
	public double perform(int cardNumber, int pin, int fromAccount, double amount) throws InvalidAccountTypeException,
			DailyLimitExceededException, InsufficientBalanceException, InvalidCredentialsException {
//		
		    System.out.println("Starting Withdrawal");
		

		if (!CredentialsChecker.checkCredentials(cardNumber, pin))
			throw new InvalidCredentialsException("Card number and PIN chosen do not match.");
		
		double limitRemaining = Accounts.getDailyWithdrawalLimit();
		double balance = Accounts.getBalance(cardNumber, fromAccount);
		double withdrawalsToday = Accounts.getWithdrawalsToday(cardNumber, fromAccount);
		
		if (balance < 0.0)
			throw new InvalidAccountTypeException("Invalid account type");

		
		limitRemaining -= withdrawalsToday;
		if (amount > limitRemaining)
			throw new DailyLimitExceededException("Daily withdrawal limit exceeded");

		if (amount > balance)
			throw new InsufficientBalanceException("Insufficient balance");

		// Update withdrawals today and account balances once we know everything
		// is
		// OK

		double newBalance = balance - amount;
		double newWithdrawalsForToday = withdrawalsToday + amount;

		System.out.println("Withdrawals today so far " + withdrawalsToday);

		System.out.println("Old Balance is " + balance);
		Accounts.setWithdrawalsToday(cardNumber, fromAccount, withdrawalsToday + amount);
		System.out.println("Updating balance");
		Accounts.setBalance(cardNumber, fromAccount, newBalance);
		System.out.println("New Balance is " + newBalance);
		System.out.println("Total Withdrawals today " + newWithdrawalsForToday);

		// Return updated balances
		System.out.println("TERMINATING CURRENT WITHDRAWAL\n \n \n");
		return newBalance;
	}
}
