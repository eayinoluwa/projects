package com.company;

import java.util.ArrayList;

public class GoodsReceivable extends StockList{
    private ArrayList<String> transactions;

    public GoodsReceivable(String name) {
        super(name);
        this.transactions = new ArrayList<String>();
    }
}
