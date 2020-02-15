package backEndSide;

import DataBase.AccountEntry;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ExposedBankingWebService {
	
	@WebMethod
	public Boolean performDBCredentialsCheck(int cardNumber, int accountType, int pin);
	
	@WebMethod
	public AccountEntry performDBDeposit(int cardNumber, int pin, int accountType, int amount);
	
	@WebMethod
	public AccountEntry performDBWithdrawal(int cardNumber, int pin, int accountType, int amount);

}
