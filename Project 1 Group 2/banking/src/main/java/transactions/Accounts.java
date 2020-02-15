package transactions;

public class Accounts {
	
	
	public static double getWithdrawalsToday(int cardNumber, int accountType) {
		return WITHDRAWALS_TODAY[cardNumber][accountType];
	}

	public static void setWithdrawalsToday(int cardNumber, int accountType, double amount) {
		WITHDRAWALS_TODAY[cardNumber][accountType] = amount;
	}

	public static double getBalance(int cardNumber, int accountType) {
		return BALANCE[cardNumber][accountType];
	}

	public static void setBalance(int cardNumber, int accountType, double amount) {
		BALANCE[cardNumber][accountType] = amount;;
	}

	public static double getDailyWithdrawalLimit() {
		return DAILY_WITHDRAWAL_LIMIT;
	}

	/**
	 * Withdrawals so far today on each card.
	 */
	private static double WITHDRAWALS_TODAY[][] = 
		{ { 0.0, 0.0, 0.0 }, 
		  { 0.0, 0.0, 0.0 }, 
		  { 0.0, 0.0, 0.0 } 
		};

	/**
	 * Maximum daily withdrawal limit for any one card.
	 */
	private static final double DAILY_WITHDRAWAL_LIMIT = 300.00;

	/**
	 * Balance for each account (will change as program runs, hence not a
	 * final.
	 */
	private static double BALANCE[][] = 
		{ { 100.0, 1000.0, 5000.0 }, 
		  { 100.0, 1000.0, 5000.0 }, 
		  { 100.0, 1000.0, -1.0 } 
		};
}
