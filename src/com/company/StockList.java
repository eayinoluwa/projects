package com.company;

import java.util.ArrayList;

public class StockList {
    private String name;
    private ArrayList<StockItem> inventory;

    public StockList(String name) {
        this.name = name;
        this.inventory = new ArrayList<StockItem>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<StockItem> getInventory() {
        return inventory;
    }

    public boolean addNew(String name, double price, Vendor vendorName){
        if (findStock(name, price, vendorName) != null) {
            System.out.println("Addition failed, Stock item is in stocklist, please try again");
            return false;
        } else {
            inventory.add(new StockItem(name, price, vendorName));
            return true;
        }
    }

    public boolean addNew(StockItem stockItem){
        if (findStock(stockItem) != null) {
            System.out.println("Addition failed, Stock item is in stocklist, please try again");
            return false;
        } else {
            inventory.add(stockItem);
            return true;
        }
    }

    public boolean addQuantity(String name, double price, Vendor vendorName, char size, int qty){
        if (findStock(name, price, vendorName) == null) {
            inventory.add(new StockItem(name,price,vendorName));
            System.out.println("Item newly added");
        }
        StockItem stock = findStock(name, price, vendorName);
        stock.addStockQty(size, qty);
        return true;
    }

    public boolean addQuantity(StockItem stockItem, char size, int qty){
        if (findStock(stockItem) == null) {
            inventory.add(stockItem);
            System.out.println("Item newly added");
        }
        StockItem stock = findStock(stockItem);
        stock.addStockQty(size, qty);
        return true;
    }

    public boolean removeQuantity(StockItem stockItem, char size, int qty){
        if (findStock(stockItem) == null) {
            System.out.println("Action failed, Stock item " + name + " not found, please try again");
            return false;
        }
        StockItem stock = findStock(stockItem);
        stock.removeStockQty(size, qty);
        return true;
    }

    public boolean removeQuantity(String name, double price, Vendor vendorName, char size, int qty){
        if (findStock(name, price, vendorName) == null) {
            System.out.println("Action failed, Stock item " + name + " not found, please try again");
            return false;
        }
        StockItem stock = findStock(name, price, vendorName);
        stock.removeStockQty(size, qty);
        return true;
    }

    public boolean removeItem(String name, double price, Vendor vendorName){
        if (findStock(name, price, vendorName) == null) {
            System.out.println("Action failed, Stock item " + name + " not found, please try again");
            return false;
        }
        StockItem stock = findStock(name, price, vendorName);
        inventory.remove(stock);
        System.out.println("item found, " + name + ", removed");
        return true;
    }

    public boolean removeItem(StockItem stockItem){
        if(findStock(stockItem) == null) {
            System.out.println("Action failed, Stock item " + stockItem.getName() + " not found, please try again");
            return false;
        }
        StockItem stock = findStock(stockItem);
        inventory.remove(stock);
        System.out.println("item found, " + name + ", removed");
        return true;
    }

    public StockItem findStock(String name, double price, Vendor vendorName){
        for (StockItem stock: inventory) {
            if (stock.getName() == name && stock.getPrice() ==price && stock.getVendorname() == vendorName) {
                return stock;
            }
        }
        return null;
    }

    public StockItem findStock(StockItem stockItem){
        for (StockItem stock: inventory) {
            if (stock.equals(stockItem)) {
                return stock;
            }
        }
        return null;
    }


    public void getItemQtyByNameAndSize(String name, char size){
        for (StockItem stock: inventory) {
            if (stock.getName().equals(name) && stock.getStockQtyBySize(size) >=0) {
                System.out.println(stock.getStockQtyBySize(size));
            }
            else {
                System.out.println("item not found.");
            }
        }
    }

    public void getPrice(String name){
        for (StockItem stock: inventory) {
            if (stock.getName().equals(name)) {
                System.out.println("stock name: " + stock.getName() + ", price: " + stock.getPrice());
            }
            else {
                System.out.println("item not found.");
            }
        }
    }

    public void getPrice(StockItem name){
        for (StockItem stock: inventory) {
            if (stock.equals(name)) {
                System.out.println("stock name: " + stock.getName() + ", price: " + stock.getPrice());
            }
            else {
                System.out.println("item not found.");
            }
        }
    }

    public void printItem(String name){
        for (StockItem stock: inventory) {
            if (stock.getName().equals(name)) {
                stock.printStockItem();
            }
            else {
                System.out.println("item not found.");
            }
        }
    }

    public void printItem(StockItem name){
        for (StockItem stock: inventory) {
            if (stock.equals(name)) {
                stock.printStockItem();
            }
            else {
                System.out.println("item not found.");
            }
        }
    }

//    public void printInventoryList() {
//        for (StockItem stock: inventory) {
//            stock.printStockItem();
//        }
//    }

    public void printVendorPerUnitCost() {
        for (StockItem stock: inventory) {
            if (stock.getTotalQty()>=0) {
                System.out.println(stock.getVendorname().getName() +" price per unit of " + stock.getPrice() +
                        " with quantity of " + stock.getTotalQty());
            }
        }
    }

    public void getTotalStockValue(){
        double value=0;
        for (StockItem stock: inventory) {
            if (stock.getTotalQty()>0) {
                String name = stock.getVendorname().getName();
                int stockQuantity = stock.getTotalQty();
                double stockPrice = stock.getPrice();
                double stockValue = stockPrice * stockQuantity;
                System.out.println(stock.getName() + " stock from " + name  + " stock quantity " + stockQuantity + " stock "
                        + " price " +stockPrice + " valued at $" +stockValue);
                value+=stockValue;
            }
        }
        System.out.println(value);
    }
}
