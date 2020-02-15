package BankingRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankingRMIDepositInterface extends Remote {
	
	public double doDeposit(int cardNo, int pin, int account, int amount) throws RemoteException;
}
