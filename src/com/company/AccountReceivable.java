package com.company;

import java.util.ArrayList;

public class AccountReceivable  extends VendorList{
    private ArrayList<String> transactions;

    public AccountReceivable(String name) {
        super(name);
        this.transactions = new ArrayList<String>();
    }
}

