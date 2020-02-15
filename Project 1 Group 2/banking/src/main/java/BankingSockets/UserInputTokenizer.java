package BankingSockets;

import java.util.*;

public class UserInputTokenizer {
	
	public Vector<String> tokenizeInput(String aLine){
		
		Vector<String> callParameters = new Vector<String>();
		
		Boolean doneTokenizing = false;
		StringTokenizer st = new StringTokenizer(aLine);

				
		while (st.hasMoreElements() && !doneTokenizing) {
		         
			String token = st.nextElement().toString();
			callParameters.add(token);
		}
		doneTokenizing = true;
		int cardNo = Integer.parseInt(callParameters.get(1));
		int pinNo = Integer.parseInt(callParameters.get(2));
		int fromAccount = Integer.parseInt(callParameters.get(3));
		int amount = Integer.parseInt(callParameters.get(4));

		return callParameters;
	}

}
