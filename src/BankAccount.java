/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author preej0747
 */
public class BankAccount {
    
    //shared between all bank accounts
    private static int currentAccounts = -1;
    
    //instance variables
    private double amount = 0;
    private int pin = 0000;
    private int accountNumber;
    private String name;
    
    //constructor
    //initial setup that needs to happen before using
    public BankAccount(String name, int pin, double initBalance){
        amount = initBalance;
        this.name = name;
        this.pin = pin;
        
        //add 1 to create an account
        BankAccount.currentAccounts++;
        
        //set the account number
        this.accountNumber = BankAccount.currentAccounts;
    }
    
    //class methods
    public void withdraw(double amount){
        if(amount > 0 && this.amount >= amount){
            this.amount -= amount;
        }
    }
    
    public void deposit(double amount){
        if(amount > 0){
            this.amount += amount;
        }
    }
    
    public double checkFunds(){
        double amount = 0;
        return this.amount;
    }
    
    public int getAccountNumber(){
        return this.accountNumber += 1;
    }
    
    public void transferFunds(BankAccount s, double amount){
        //check for proper amount
        if(this.amount >= amount){
            
            //do the transfer
            this.withdraw(amount);
            s.deposit(amount);
        }
}
}