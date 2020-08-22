package com.company;

import java.util.ArrayList;

public class Inventory extends StockList {
    private ArrayList<String> transactions;

    public Inventory(String name) {
        super(name);
        this.transactions = new ArrayList<>();
    }
}
