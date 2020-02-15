package BankingRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankingRMIWithdrawalInterface extends Remote {

	public double doWithdrawal(int cardNo, int pin, int account, int amount) throws RemoteException;
}
