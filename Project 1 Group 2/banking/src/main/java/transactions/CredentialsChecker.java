package transactions;

public class CredentialsChecker {
	public static boolean checkCredentials(int cardNumber, int pin) {
		if (cardNumber>=PIN.length)
			return false;
		return (PIN[cardNumber] == pin);
	}
	
	private static final int PIN [] =
	    { 
	        0,  // dummy for nonexistent card 0
	        42, 
	        1234 
	    };
}
