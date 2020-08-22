package com.company;

public class Vendor {
    private String name;
    private String address;
    private String contact;
    private String product;

    public Vendor(String name, String product, String contact, String address) {
        this.name = name;
        this.product = product;
        this.contact = contact;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getProduct() {
        return product;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
