package com.techelevator;

public class SavingsAccount extends BankAccount{

    int fee = 2;
    int newBalance;

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw){
        int testBalance = super.getBalance() - (amountToWithdraw + fee);
        if(testBalance < 0) {
            return getBalance();
        }
        else {
            newBalance = super.withdraw(amountToWithdraw);
            if(newBalance < 150){
                 super.withdraw(fee);
                 return super.getBalance();
            }
            else {
                return super.getBalance();
            }
        }
    }


}
