
package middlewareSide;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="availableBalance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dailyLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ownerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="withdrawals" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountEntry", propOrder = {
    "accountType",
    "availableBalance",
    "balance",
    "cardNumber",
    "dailyLimit",
    "ownerID",
    "pin",
    "withdrawals",
    "displayedBalance"
})
public class AccountEntry {

    protected int accountType;
    protected int availableBalance;
    protected int balance;
    protected int cardNumber;
    protected int dailyLimit;
    protected int ownerID;
    protected int pin;
    protected int withdrawals;
    protected String displayedBalance;

    /**
     * Gets the value of the accountType property.
     * 
     */
    public int getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     */
    public void setAccountType(int value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the availableBalance property.
     * 
     */
    public int getAvailableBalance() {
        return availableBalance;
    }

    /**
     * Sets the value of the availableBalance property.
     * 
     */
    public void setAvailableBalance(int value) {
        this.availableBalance = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     */
    public void setBalance(int value) {
        this.balance = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     */
    public int getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     */
    public void setCardNumber(int value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the dailyLimit property.
     * 
     */
    public int getDailyLimit() {
        return dailyLimit;
    }

    /**
     * Sets the value of the dailyLimit property.
     * 
     */
    public void setDailyLimit(int value) {
        this.dailyLimit = value;
    }

    /**
     * Gets the value of the ownerID property.
     * 
     */
    public int getOwnerID() {
        return ownerID;
    }

    /**
     * Sets the value of the ownerID property.
     * 
     */
    public void setOwnerID(int value) {
        this.ownerID = value;
    }

    /**
     * Gets the value of the pin property.
     * 
     */
    public int getPin() {
        return pin;
    }

    /**
     * Sets the value of the pin property.
     * 
     */
    public void setPin(int value) {
        this.pin = value;
    }

    /**
     * Gets the value of the withdrawals property.
     * 
     */
    public int getWithdrawals() {
        return withdrawals;
    }

    /**
     * Sets the value of the withdrawals property.
     * 
     */
    public void setWithdrawals(int value) {
        this.withdrawals = value;
    }
    
    
    /**
     * Gets the value of the displayedBalance property.
     * 
     */
    public String getDisplayedBalance() {
        return displayedBalance;
    }

    /**
     * Sets the value of the displayedBalance property.
     * 
     */
    public void setDisplayedBalance(String balance) {
        this.displayedBalance = balance;
    }

}
