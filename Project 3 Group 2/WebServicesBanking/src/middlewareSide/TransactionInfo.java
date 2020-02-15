package middlewareSide;

/*
 * The TransactionInfo class with its getters and setters. Keeps in an object 
 * the current transaction's info
 */
public class TransactionInfo {
	
	int cardNumber;
	int pin;
	int accountType;
	int transactionType;
	int amount;
	
	
	public void setCardNumber(int cardNo) {
		cardNumber = cardNo;
		
	};
	
	public int getCardNumber() {
		return this.cardNumber;
		
	};
	
	
	public void setPin(int thePin) {
		pin = thePin;
		
	};
	
	public int getPin() {
		return this.pin;
		
	};
	
	
	public void setAccountType(int accType) {
		accountType = accType;
		
	};
	
	public int getAccountType() {
		return this.accountType;
		
	};
	
	public void setTransactionType(int transType) {
		transactionType = transType;
		
	};
	
	public int getTransactionType() {
		return this.transactionType;
		
	};
	
	public void setAmount(int theAmount) {
		amount = theAmount;
		
	};
	
	public int getAmount() {
		return this.amount;
		
	};	

}
