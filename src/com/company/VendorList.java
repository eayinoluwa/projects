package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VendorList {
    private String name;
    private Map<Vendor,Double> customerBalance;
    private ArrayList<Vendor> vendors;
    private double totalPrice;

    public VendorList(String name) {
        this.name = name;
        this.customerBalance = new HashMap<Vendor, Double>();
        this.vendors =  new ArrayList<Vendor>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Vendor> getVendors() {
        return vendors;
    }

    public boolean addNewVendor(Vendor vendor){
        if(findVendor(vendor)!=null){
            System.out.println("vendor already on the list, please add a new vendor");
            return false;
        }
        vendors.add(vendor);
        System.out.println("Vendor " + vendor.getName() + " was successfully added");
        return true;
    }

    public boolean addNewVendor(String name, String product, String contact, String address){
        if(findVendor(name, product) != null){
            System.out.println("vendor already on the list, please add a new vendor");
            return false;
        }
        vendors.add(new Vendor(name, product, contact, address));
        System.out.println("Vendor " + name + " was successfully added");
        return true;
    }

    public boolean addToExistingVendor(String name, String product, String contact, String address, double price, int qty){
        double transactionCost = price * qty;
        if(transactionCost>=0){
            if (findVendor(name, product) == null) {
                vendors.add(new Vendor(name,product,contact,address));
                System.out.println("Vendor newly created");
            }
            Vendor stock = findVendor(name, product);
            if (customerBalance.containsKey(stock)){
                customerBalance.put(stock,customerBalance.get(stock)+transactionCost);
                System.out.println("quantity added to the available stock for the size");
            }
            else {
                customerBalance.put(stock,transactionCost);
                System.out.println("quantity added to the size, size had no stock prior to addition");
            }
            this.totalPrice+=transactionCost;
            return true;
        }
        else {
            System.out.println("negative addition, please check your numbers");
            return false;
        }
    }

    public boolean addToExistingVendor(Vendor vendor, double price, int qty){
        double transactionCost = price * qty;
        if (transactionCost>=0){
            if (findVendor(vendor) == null) {
                vendors.add(vendor);
                System.out.println("Vendor newly created");
            }
            Vendor stock = findVendor(vendor);
            if (customerBalance.containsKey(stock)){
                customerBalance.put(stock,customerBalance.get(stock)+transactionCost);
                System.out.println("quantity added to the available stock for the size");
            }
            else {
                customerBalance.put(stock,transactionCost);
                System.out.println("quantity added to the size, size had no stock prior to addition");
            }
            this.totalPrice+=transactionCost;
            return true;
        }
        else {
            System.out.println("addition failed, negative value");
            return false;
        }
    }

    public boolean removeExistingBalance(String name, String product, double price, int qty){
        double transactionCost = price * qty;
        if (findVendor(name, product) ==null) {
            System.out.println("Vendor not found");
            return false;
        }
        Vendor stock= findVendor(name, product);
        if (customerBalance.get(stock)>=transactionCost) {
            customerBalance.put(stock, customerBalance.get(stock) - transactionCost);
            System.out.println( name + " balance has been reduced by " +transactionCost);
            this.totalPrice -= transactionCost;
            return true;
        }else {
            System.out.println( name + " current balance is "+ customerBalance.get(stock) + ", the transaction " +
                    "cost  " +transactionCost);
            return false;
        }
    }

    public boolean removeExistingBalance(Vendor vendor, double price, int qty){
        double transactionCost = price * qty;
        if (findVendor(vendor) == null) {
            System.out.println("Vendor not found");
            return false;
        }
        Vendor stock = findVendor(vendor);
        if (customerBalance.get(stock)>=transactionCost) {
            customerBalance.put(stock, customerBalance.get(stock) - transactionCost);
            System.out.println( name + " balance has been reduced by " +transactionCost);
            this.totalPrice -= transactionCost;
            return true;
        }else {
            System.out.println( name + " current balance is "+ customerBalance.get(stock) + ", the transaction " +
                    "cost  " +transactionCost);
            return false;
        }
    }

    public Vendor findVendor(String name, String product){
        for(int i=0; i < vendors.size(); i++){
            Vendor existingVendor = vendors.get(i);
            if (existingVendor.getName() ==name && existingVendor.getProduct() == product){
                return existingVendor;
            }
            return null;
        }
        return null;
    }

    public Vendor findVendor(String name){
        for(Vendor existingVendor : vendors){
            if (existingVendor.getName().equals(name)){
                return existingVendor;
            }
            return null;
        }
        return null;
    }

    public Vendor findVendor(Vendor vendor){
        for(Vendor vend: vendors){
            if (vend.equals(vendor)){
                return vend;
            }
        }
        System.out.println("Vendor not found");
        return null;
    }

    public boolean updateVendorAddress(String vendorName, String newAddress){
        for(Vendor vendor: vendors){
            if (vendor.getName()==vendorName){
                String oldAddress = vendor.getAddress();
                vendor.setAddress(newAddress);
                System.out.println("address updated");
                return true;
            }
        }
        return false;
    }

    public boolean updateVendorContact(String vendorName, String contact){
        for(Vendor vendor: vendors){
            if (vendor.getName()==vendorName){
                vendor.setContact(contact);
                System.out.println("contact updated");
                return true;
            }
        }
        return false;
    }

    public boolean updateVendorProduct(String vendorName, String product){
        for(Vendor vendor: vendors){
            if (vendor.getName()==vendorName){
                vendor.setProduct(product);
                System.out.println("product updated");
                return true;
            }
        }
        return false;
    }

    public double gettCustomerBalance(Vendor vendor){
        if (customerBalance.containsKey(vendor)){
            return customerBalance.get(vendor);
        }
        else return 0.00;
    }

    public double gettCustomerBalance(String vendorName){
        for (int i =0; i < vendors.size(); i++){
            Vendor customer = vendors.get(i);
            if (customer.getName() ==vendorName){
                return customerBalance.get(customer);
            }
        }
        return 0.00;
    }

    public double printVendorList(){
        for (Vendor i: vendors){
            System.out.println(i.getName() +" balance of $" +customerBalance.get(i));
        }
        return 0.00;
    }

}
