package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private String accountNumber;
    private String accountType;
    private double balance;
    private ArrayList<String> accountSummary;
    private String bankAddress;
    private String accountManager;

    public Bank(String name, String accountNumber, String accountType, double initialDeposit) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        balance = initialDeposit;
        accountSummary = new ArrayList<String>();
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean withdraw(double amount){
        if(this.getBalance() >=amount && amount>=0) {
            this.balance-=amount;
            return true;
        }
        else {
            System.out.println("Negative amount or insufficient balance, withdrawal failed");
            return false;
        }
    }

    public boolean deposit(double amount){
        if(amount>=0) {
            System.out.println("amount " + amount + " deposited");
            this.balance+=amount;
            return true;
        }
        else {
            System.out.println("Negative amount, deposit failed");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getAccountSummary() {
        return accountSummary;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public String getAccountManager() {
        return accountManager;
    }
}
