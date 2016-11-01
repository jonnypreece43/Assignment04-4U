/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author preej0747
 */
public class TestBankAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BankAccount a1 = new BankAccount("Jonny", 1214, 200);
        System.out.println("Initial Balance: " + a1.checkFunds());
        System.out.println("A1 Account: " + a1.getAccountNumber());
        a1.deposit(500);
        System.out.println("Balance: " + a1.checkFunds());
        a1.withdraw(30);
        a1.withdraw(100);
        System.out.println("Balance: " + a1.checkFunds());
        
        BankAccount a2 = new BankAccount("Another", 1321, 300);
        System.out.println("Initial Balance: " + a2.checkFunds());
        
    }
}
