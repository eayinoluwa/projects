package com.company;

import java.util.HashMap;
import java.util.Map;

public class StockItem {
    private String name;
    private double price;
    private Vendor vendorname;
    private Map<Character,Integer>quanityPerSize;
    private int totalQty;

    public StockItem(String name, double price, Vendor vendorname) {
        this.name = name;
        this.price = price;
        this.vendorname = vendorname;
        this.quanityPerSize = new HashMap<Character, Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vendor getVendorname() {
        return vendorname;
    }

    public void setVendorname(Vendor vendorname) {
        this.vendorname = vendorname;
    }

    public Map<Character, Integer> getQuanityPerSize() {
        return quanityPerSize;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void addStockQty(char size, int Qty){
        if (quanityPerSize.containsKey(size)){
            quanityPerSize.put(size,quanityPerSize.get(size)+Qty);
            System.out.println("quantity added to the available stock for the size");
            this.totalQty+=Qty;
        }
        else {
            if (Qty>=0){
                quanityPerSize.put(size,Qty);
                System.out.println("quantity added to the size, size had no stock prior to addition");
                this.totalQty+=Qty;
            }
            else {
                System.out.println("addition failed, negative value");
            }
        }
    }

    public int getStockQtyBySize(char size){
        if (quanityPerSize.containsKey(size)){
            return quanityPerSize.get(size);
        }
        else{
            System.out.println(size +" not found");
            return 0;
        }
    }

    public void removeStockQty(char size, int Qty){
        if (quanityPerSize.containsKey(size)){
            if (Qty > quanityPerSize.get(size)){
                System.out.println("available quantity for " + size + " is " + quanityPerSize.get(size));
                System.out.println("requested quantity is more than available products for size " + size);
            } else {
                quanityPerSize.put(size, quanityPerSize.get(size) - Qty);
                System.out.println("quantity removed from the available stock for the size");
                this.totalQty-=Qty;
            }
        }
        else {
            System.out.println("stock not found");
        }
    }

    public void printStockItem(){
        for (char i: quanityPerSize.keySet()){
            System.out.println(quanityPerSize.get(i));
        }
    }
}
