package com.techelevator;

public class CheckingAccount extends BankAccount{


    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw){
        int testBalance = super.getBalance() - amountToWithdraw;
        if(testBalance <= -100){
            return super.getBalance();
        }
        if(testBalance < 0 && testBalance > -100) {
            super.withdraw(amountToWithdraw + 10);
            return super.getBalance();
        }
        else {
            super.withdraw(amountToWithdraw);
            return super.getBalance();
        }
    }
}
