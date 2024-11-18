package ie.atu.serialization;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    transient String pin;
    transient double LastAccessTime;

    
    public BankAccount (String accountNumber, String accountHolder, double balance,  String pin, double LastAccessTime) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;
        this.LastAccessTime = LastAccessTime;
    }
    
    @Override
    public String toString() {
        return "BankAccount{accountNumber='" + accountNumber + "', accountHolder='" + 
               accountHolder + "'balance=" + balance + "', pin =" + pin + " LastAccessTime" + LastAccessTime + "'}";
    }
}