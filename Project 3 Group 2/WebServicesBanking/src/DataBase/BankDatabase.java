package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.Statement;

public class BankDatabase {

	private Connection conn;
	
	/*****************************************************************************
	 * IMPORTANT BELOW
	 * ITEC 4020 IMPORTANT THIS STRING HAS TO BE CHANGED TO YOUR OWN DIRECTORY PATH
	 *****************************************************************************
	 */
	private static String url = "jdbc:sqlite:C:\\Users\\kostas\\Eclipse-Test-Staging\\WebBanking\\bank.db";

	/***************************************************************************
	 * ITEC 4020 The getAcountInfo method.
	 * Based on the cardNumber provided and the TypeOfAccount (i.e. Savings or Chequing)
	 * the method queries he Data base and get the information for this account (i.e.
	 * all the fields for this table entry. It then creates an object of type AccountEntry
	 * and stores this information in this transient object. It then returns this transient
	 * object.
	 * **************************************************************************
	 */
	
	public AccountEntry getAccountInfo(int cardNumber, int typeOfAccount) throws AccountNotFound {
		
		// It will hold the SQL query depending on the account type (see code below)
		String sql_select_account;
		
		// ITEC 4020 The SQL statements. Note the ? which will be replaced by the 
		// actual value setInt method (see below)
		String sql_select_ownerID ="SELECT id FROM customers WHERE cardID = ?";
		String sql_select_pin = "SELECT pin FROM customers WHERE id = ?";
		// ITEC 4020 The result will be the account object. Initialized here to null
		AccountEntry account = null;
		String accountType;
		// ITEC 4020 the ownerID and the pin values which wil be extracted from  the DB
		// are initialized to -1
		int ownerID = -1;
		int pin = -1;
		// The variable rs that represents the result of each  query. 
		ResultSet rs;
		PreparedStatement pstmt;
		
		
		try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			// ITEC 4020 Get the "id" field of the DB table given the cardNumber
			// and the account type, by defining a statement (i.e. pstmt) and executing
			// it
			pstmt = conn.prepareStatement(sql_select_ownerID);
			// ITEC 4020 substitute the first (an only) ? with the value of the 
			// variable cardNumber so that we can execute the query specified by 
			// the sql_select_ownerID string
			pstmt.setInt(1, cardNumber);
			// execute the quetry and pass the results tothe variable rs
		    rs = pstmt.executeQuery();
		    while (rs.next()) {
		    	// ITEC 4020 get the value of the query (heer it is just one
		    	// number (i.e. the value of the "id" field of the DB table (see DB's
		    	// structure
		        ownerID = rs.getInt("id");
	        }
		    // ITEC 4020 close the statement and the result stream.
		    pstmt.close();
		    rs.close();
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			pstmt = conn.prepareStatement(sql_select_pin);
			pstmt.setInt(1, ownerID);
		    rs = pstmt.executeQuery();
		    while (rs.next()) {
		    	// ITEC 4020 Get the pin value from the query result stored in variable rs
		    	// NOTE: This is the pin's value that comes from the
		    	// DB. It is stored on the transient object account, so it can later 
		    	// be checked against the cardNumber/pin combination provided by the user
		    	// (see CredentialsChecker class)
		    	
		        pin = rs.getInt("pin");
	        }
		    pstmt.close();
		    rs.close();
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		switch (typeOfAccount) {
		case 1:
			sql_select_account = "SELECT balance,availableBalance,dailyLimit FROM chequing WHERE ownerID = ?";
			accountType  = "Chequing";
			break;
		case 2:
			sql_select_account = "SELECT balance,availableBalance,dailyLimit FROM savings WHERE ownerID = ?";
			accountType  = "Savings";
			break;
		default:
			throw new AccountNotFound();
		}
		
		try {
		
			pstmt = conn.prepareStatement(sql_select_account);
			pstmt.setInt(1, ownerID);
			rs = pstmt.executeQuery();
			
			if(rs == null) {
				System.out.println("QUERY RESULT IS NULL");
			}
			
			if (rs == null) {
				throw new AccountNotFound(accountType);
			} else {
				// ************************************************************
				// ITEC 4020 HERE WE CREATE AND SET THE VALUES OF THE TRANSIENT 
				// account OBJECT (it is of type AccountEntry
				// ************************************************************
				account = new AccountEntry(ownerID, cardNumber, pin, typeOfAccount, 
						                   rs.getInt("balance"), 
						                   rs.getInt("availableBalance"), 
						                   rs.getInt("dailyLimit"), 0);
			}
		} catch (SQLException e) {
			System.out.println("Account info: " + e.getMessage());
		}
		finally{
		    try{
		        conn.close();
		    }catch(Exception e){
		    	System.out.println("Cannot close DB: " + e.getMessage());
		    }}
		
		
		
		return account;
	}
	
	
	/************************************************************************
	 * ITEC 4020 The updateAccountInfo method. It takes as argument the 
	 * an AccountEntry object with all the account's info and new balance
	 * (i.e. after a deposit or a withdrawal) and sets the new values in the DB
	 * **********************************************************************
	 */
	
	public void updateAccountInfo(AccountEntry account) throws AccountNotFound {
		String sql_update;
		String sql_select_ownerID = "SELECT id FROM customers WHERE cardID = ?";
		ResultSet rs;
		int ownerID = -1; 
		
		// ITEC 4020 Here in this try block we get a driver for sqlite and we get 
		// a connection to the DB specified by the string "url" YOU NEED TOP CHANGE 
		// IT TO YOUR OWN DIRECTORY PATH
		try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// ITEC 4020 define the variable pstmt
		PreparedStatement pstmt;
		// ITEC 4020 get the "id" for a record given the cardNumber
		try {
			pstmt = conn.prepareStatement(sql_select_ownerID);
			pstmt.setInt(1, account.getCardNumber());
		    rs = pstmt.executeQuery();
		    // ITEC get the value of "id" record field from the query result "rs"
		    while (rs.next()) {
		        ownerID = rs.getInt("id");
	        }
		    pstmt.close();
		    rs.close();
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		switch (account.getAccountType()) {
		case 1:
			// ITEC 4020 the account type os chequing
			sql_update = "UPDATE chequing SET balance = ? WHERE ownerID = ?";
			break;
		case 2:
			// ITEC 4020 The account type is savings. See where the account object gets
			// its values (Hint see getAccountInfo method above where the account object is
			// created
			sql_update = "UPDATE savings SET balance = ? WHERE ownerID = ?";
			break;
		default:
			throw new AccountNotFound();
		}
		// ****************************************************
		// ITEC 4020 DO THE UPDATE -- FOR YOU TO FILL THIS !!!!
		// ****************************************************
		try {
			// ITEC 4020 Set the value to the pstmt variable (i.e. create a new 
			// SQL statement object using the Connection "conn" and using 
			// the "sql_update" string as a parameter). You need to apply the 
			// "prepareStatement methid of the "conn" object.
			
			pstmt = conn.prepareStatement(sql_update);
			
			// ITEC 4020 set the value of the balance from the AcountEntry object 
			// "account" to the first placeholder ? in the "sql_update" query string
			// using the setInt method of the pstmt
		
			pstmt.setInt(1, account.getBalance());
			
			// ITEC 4020 set the value of the ownerID variable as we got it earlier 
			// in this method to the second  placeholder ? in the "sql_update" 
			// query string using the setInt method of the pstmt
			
			pstmt.setInt(2, ownerID);

			// ITEC 4020 Execute update using the executeUpdate method of the pstmt
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			System.out.println("Update account: " + e.getMessage());
		}
		finally{
		    try{
		        conn.close();
		    }catch(Exception e){
		    	System.out.println("Cannot close DB: " + e.getMessage());
		    }}
	}
	
	

	public class CustomerNotFound extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CustomerNotFound(int cardID) {
			super("Customer with cardID " + cardID + "does not exist.");
		}

	}

	public class AccountNotFound extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AccountNotFound(String accountType) {
			super("Customer does not have a " + accountType + "account.");
		}
		
		public AccountNotFound() {
			super("Invalid account type.");
		}

	}

}

