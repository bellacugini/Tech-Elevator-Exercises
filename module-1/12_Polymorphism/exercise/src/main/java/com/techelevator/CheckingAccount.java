package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolder, String accountNumber, int balance) {
        super(accountHolder, accountNumber, balance);
    }

    public CheckingAccount(String accountHolder, String accountNumber) {

        super(accountHolder, accountNumber);
    }

    @Override
    public int deposit(int transferAmount) {
        return super.deposit(transferAmount);
    }

    @Override
    public int withdraw(int transferAmount) {
        return super.withdraw(transferAmount);
    }
}
