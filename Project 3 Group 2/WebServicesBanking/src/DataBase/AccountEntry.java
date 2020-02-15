package DataBase;

/**************************************************************************
 * The AccountEntry class for the transient object passed by the getAccountInfo method
 * (see BankDatabase class) with its getters and setters.
 * ************************************************************************
 */

public class AccountEntry {
	private int ownerID;
	private int pin;
	private int cardNumber;
	private int accountType;
	private int balance;
	private int availableBalance;
	private int dailyLimit;
	private int withdrawals;
	private String displayedBalance;
	
	/** Construstor for an account entry
	 * @param balance			Account's balance
	 * @param availableBalance	Balance available at the moment
	 * @param dailyLimit		Daily limit for that account
	 * @param withdrawals		Withdrawals performed today
	 */
	
	public AccountEntry() {
		new AccountEntry();
	};
	
	
	
	public AccountEntry(int ownerID, int cardNumber, int pin, int accountType, int balance, int availableBalance, int dailyLimit, int withdrawals) {
		super();
		this.ownerID = ownerID;
		this.cardNumber = cardNumber;
		this.pin = pin;
		this.accountType = accountType;
		this.balance = balance;
		this.availableBalance = availableBalance;
		this.dailyLimit = dailyLimit;
		this.withdrawals = withdrawals;
	}

	public int getOwnerID() {
		return ownerID;
	}
	

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public int getPin() {
		return pin;
	}
	

	public void setPin(int pin) {
		this.pin = pin;
	}


	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(int availableBalance) {
		this.availableBalance = availableBalance;
	}

	public int getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(int dailyLimit) {
		this.dailyLimit = dailyLimit;
	}

	public int getWithdrawals() {
		return withdrawals;
	}

	public void setWithdrawals(int withdrawals) {
		this.withdrawals = withdrawals;
	}
	
	
    public String getDisplayedBalance() {
        return displayedBalance;
    }


    public void setDisplayedBalance(String balance) {
        this.displayedBalance = balance;
    }
	
}
