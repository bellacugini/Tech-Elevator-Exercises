package com.techelevator;

public class CreditCardAccount implements Accountable {

    private String accountHolder;
    private String accountNumber;
    private int debt;

    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getDebt() {
        return this.debt;
    }

@Override
    public int getBalance() {
        return debt * (-1);
    }

    public int pay(int amountToPay) {
        debt -= amountToPay;
        return debt;
    }

    public int charge(int amountToCharge) {
        debt += amountToCharge;
        return debt;
    }
}
