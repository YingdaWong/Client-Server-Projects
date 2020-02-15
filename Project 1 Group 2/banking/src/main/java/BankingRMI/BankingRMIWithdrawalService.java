package BankingRMI;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;

import transactions.Withdrawal;
import transactions.exceptions.DailyLimitExceededException;
import transactions.exceptions.InsufficientBalanceException;
import transactions.exceptions.InvalidAccountTypeException;
import transactions.exceptions.InvalidCredentialsException;

public class BankingRMIWithdrawalService extends UnicastRemoteObject implements BankingRMIWithdrawalInterface {

	
	protected BankingRMIWithdrawalService() throws RemoteException {
		super();
	}
	public double doWithdrawal(int cardNo, int pin, int account, int amount) throws RemoteException {
		
		Withdrawal aWithdrawal= new Withdrawal();
		
		double result = -1;
		try {
			result = aWithdrawal.perform(cardNo, pin, account, amount);
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
