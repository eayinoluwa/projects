package com.company;

import java.util.ArrayList;

public class Staff {
    private static int IDcounter= 0000;
    private int staffID;
    private String name;
    private String department;
    private int level;
    private boolean employmentStatus;
    private ArrayList<String> Transactions;

    public Staff(String name, String department, int level) {
        this.name = name;
        this.department = department;
        this.level = level;
        IDcounter++;
        this.staffID = IDcounter;
        employmentStatus = true;
        Transactions = new  ArrayList<String>();
    }

    public Staff() {
    }

    public int getStaffID() {
        return staffID;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<String> getTransactions() {
        return Transactions;
    }

    public boolean getEmploymentStatus() {
        return employmentStatus;
    }

    public void setStaffDepartment(Staff staff1, String department) {
        this.department = department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setStaffLevel(Staff staff1, int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStaffEmploymentStatus(Staff staff1, boolean employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public void setEmploymentStatus(boolean employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public void info(){
        System.out.println("Staff name " + name + ", staff department " + department);
    }
}
