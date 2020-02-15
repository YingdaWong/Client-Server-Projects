package backEndSide;

import DataBase.AccountEntry;
import DataBase.BankDatabase;
import DataBase.BankDatabase.AccountNotFound;
// import transactions.DBCredentialsChecker;




import javax.jws.WebService;

//import transactions.DBCredentialsChecker;

@WebService(endpointInterface = "backEndSide.ExposedBankingWebService")
public class ExposedBankingWebServiceImpl implements ExposedBankingWebService {

	@Override
	public Boolean performDBCredentialsCheck(int cardNumber, int accountType, int pin) {
		AccountEntry account = null;
		BankDatabase database = new BankDatabase();

		try {
			account = database.getAccountInfo(cardNumber, accountType);

			if (account == null) {
				return false;
			}

			if (account.getCardNumber() == cardNumber && account.getPin() == pin)
				return true;
			else
				return false;

		} catch (AccountNotFound e) {
			System.out.println("Invalid account type");
			return false;
		}

	}


	@Override
	public AccountEntry performDBDeposit(int cardNumber, int pin, int accountType, int amount) {
		// PROJECT3 ADD THE CODE OF performDBDeposit HERE. Look at the code in Project 2
		// and also the code in performDBWithdrawal below as an example.
		AccountEntry account = null;
		int result = -1;
        BankDatabase database = new BankDatabase();
        
        Boolean checkValue = false;
        
        try {
			account = database.getAccountInfo(cardNumber, accountType);
		} catch (AccountNotFound e) {
			System.out.println("Invalid account type");
			return null;
		}
        
        checkValue = performDBCredentialsCheck(cardNumber, accountType, pin);
        
        if(checkValue) {

			// ITEC 4020 if the provided card number and pin match the ones in the DB Renew balance
			int balance = account.getBalance() + amount;
			// ITEC 4020 use the setBalance method on the account object (it is of type AccountEntry)
			// to set the new balance
			account.setBalance(balance);
			
			// ITEC 4020 Update database with the information stored in the transient object 
			// "account"
			try {
				/*
				 * ITEC 4020 Use the method updateAccountInfo to update the contents of 
				 * the DB
				 */
				database.updateAccountInfo(account);
				// ITEC 4020 set the value of the "result" variable to the new balance
				result = balance;
			} catch (AccountNotFound e) {
				System.out.println("Invalid account type");
				return null;
				
			}
			/* ITEC 4020 
			 * Return the transient object "account"
			 */
			return account;
        }
		return account;
	}

	@Override
	public AccountEntry performDBWithdrawal(int cardNumber, int pin, int accountType, int amount) {

		/*
		 * ITEC 4020 YOU WRITE THIS MAKE SURE YOU CHECK THAT THE amount <= of the
		 * balance field in the account object you get when you will call the
		 * getAccountInfo method (see performDBDeposit method in the DBDeposit
		 *
		 */

		AccountEntry account = null;
		int result = -1;
		BankDatabase database = new BankDatabase();

		Boolean checkValue = false;

		try {
			account = database.getAccountInfo(cardNumber, accountType);

		} catch (AccountNotFound e) {
			System.out.println("Invalid account type");
			return null;
		}

		if (!(amount <= account.getBalance())) {
			System.out.println("Insufficient available balance");
			return null;
		}

		// Update withdrawals today and account balances once we know everything
		// is OK.

		checkValue = performDBCredentialsCheck(cardNumber, accountType, pin);

		if (checkValue) {

			// ITEC 4020 if the provided card number and pin match the ones in the DB Renew
			// balance
			int balance = account.getBalance() - amount;
			// ITEC 4020 use the setBalance method on the account object (it is of type
			// AccountEntry)
			// to set the new balance
			account.setBalance(balance);

			// ITEC 4020 Update database with the information stored in the transient object
			// "account"
			try {
				/*
				 * ITEC 4020 Use the method updateAccountInfo to update the contents of the DB
				 */
				database.updateAccountInfo(account);
				// ITEC 4020 set teh value of the "result" variable to the new balance
				result = balance;
			} catch (AccountNotFound e) {
				System.out.println("Invalid account type");
				return null;

			}
			/*
			 * ITEC 4020 Return the transient object "account"
			 */
			return account;
		}
		return account;
	}

}
