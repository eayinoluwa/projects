package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class BankList {
    private String name;
    private ArrayList<Bank> banks;
    private ArrayList<String> bankTransactions;

    public BankList(String name) {
        this.name = name;
        this.banks = new ArrayList<Bank>();
        this.bankTransactions = new ArrayList<String>();
    }

    public boolean addBank(String name, String accountNumber, String accountType, double initialDeposit){
        if (findBank(name, accountNumber) !=null) {
            System.out.println("bank is already on the list");
            return false;
        }
        banks.add(new Bank(name, accountNumber, accountType, initialDeposit));
        System.out.println(name + " bank added.");
        return true;
    }

    public boolean removeBank(String name, String accountNumber){
        if (findBank(name, accountNumber) ==null) {
            System.out.println("bank not on the list");
            return false;
        }
        banks.remove(findBank(name, accountNumber));
        System.out.println("bank removed.");
        return true;
    }

    public boolean withdraw(String bankName, String bankAcctNo, double withdrawal){
        if (findBank(bankName, bankAcctNo) == null) {
            System.out.println("bank not found");
            return false;
        }
        Bank bank2 = findBank(bankName, bankAcctNo);
        if(bank2.withdraw(withdrawal)) {
            System.out.println("bank found, withdrawal done");
            return true;
        }
        else {
            return false;
        }
    }

    public void deposit(String name, String accountNumber, double amount){
        if (findBank(name, accountNumber) ==null) {
            System.out.println("bank not found");
            return;
        }
        Bank bank2 = findBank(name, accountNumber);
        bank2.deposit(amount);
    }

    public Bank findBank(String bankName, String accountNumber){
        for (Bank bankfound : banks) {
            if (Objects.equals(bankfound.getName().toLowerCase(), bankName.toLowerCase()))
                if (bankfound.getAccountNumber().equals(accountNumber)) {
                    return bankfound;
                }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }

    public void printBalance(String bankName){
        for (Bank foundBank : banks) {
            if (foundBank.getName().equals(bankName)) {
                System.out.println("Bank balance of " + bankName + " bank " + foundBank.getBalance());
                return;
            }
        }
        System.out.println("Bank not found");
    }

    public void viewBanksInfo(){
        for (Bank bank: banks){
            System.out.println("Bank name: " + bank.getName() + ", account number: " + bank.getAccountNumber() +
                    ", account type: " + bank.getAccountType() + ", account balance: " + bank.getBalance());
        }
    }

}
