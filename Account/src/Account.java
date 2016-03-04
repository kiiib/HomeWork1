/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author KiiibLau
 */
public class Account {
    private double balance; // instance variable that stores the balance
    
    public Account( double initialBalance )
    {
        // validate that initialBalance is greater than 0.0
        // if it is not, balance is initialized to the default value 0.0
        if( initialBalance > 0)
            balance = initialBalance;
    }   //end Account constructor
    
    //credit (add) an amount to the account
    public void credit ( double amount )
    {
        balance = balance + amount; //add amount to balance
    } // end method credit
    
    //return the account balance
    public double getBalance()
    {
        return balance; // gives the value of balance to the calling method
    }   // end method getBalance
}   // end class Account
