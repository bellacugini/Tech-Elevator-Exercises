package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable{

    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Accountable> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Accountable[] getAccounts() {
        Accountable[] accountArray = new Accountable[this.accounts.size()];
        for(int i = 0; i < this.accounts.size(); i++){
            accountArray[i] = this.accounts.get(i);
        }
        return accountArray;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addAccount(Accountable newAccount){
        this.accounts.add(newAccount);
    }

    public boolean isVip(){
        int balance = 0;

        for(int i = 0; i < this.accounts.size(); i++){
            Accountable acc = this.accounts.get(i);
            balance += acc.getBalance();
        }

        if(balance >= 25000){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int getBalance() {
        return getBalance();
    }
}
