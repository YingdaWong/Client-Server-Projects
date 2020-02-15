package BankingRMI;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import transactions.Deposit;
import transactions.exceptions.DailyLimitExceededException;
import transactions.exceptions.InsufficientBalanceException;
import transactions.exceptions.InvalidAccountTypeException;
import transactions.exceptions.InvalidCredentialsException;


public class BankingRMIDepositService extends UnicastRemoteObject implements BankingRMIDepositInterface {

	private static final long serialVersionUID = 1L;
	
	protected BankingRMIDepositService() throws RemoteException {
		super();
	}
		
	public double doDeposit(int cardNo, int pin, int account, int amount) {
		Deposit aDeposit = new Deposit();
		
		double result = -1;
		try {
			result = aDeposit.perform(cardNo, pin, account, amount);
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
		return result;
	}
		
		
}
