package com.company;

import java.util.ArrayList;

public class StaffList {
    private String name;
    private ArrayList<Staff> companyStaffList;
    private ArrayList<String> StaffListTransactions;

    public String getName() {
        return name;
    }

    public StaffList(String name) {
        this.name = name;
        this.companyStaffList = new ArrayList<Staff>();
        this.StaffListTransactions  = new ArrayList<String>();
    }

    public boolean addStaff(Staff newStaff){
        if(findStaff(newStaff) !=null){
            System.out.println("Staff is already on company's record, with ID " + newStaff.getStaffID());
            return false;
        }
        else {
            companyStaffList.add(newStaff);
            return true;
        }
    }

    public boolean addStaff(String name, String department, int level){
        if (department.equals("Human Resource")){
            companyStaffList.add(new HRStaff(name, level));
            System.out.println( name + " added to Human Resources");
            return true;
        }
        else if (department.equals("Finance")){
            companyStaffList.add(new FinanceStaff(name, level));
            System.out.println( name + " added to Finance");
            return true;
        }
        else if(department.equals("Logistic")) {
            companyStaffList.add(new LogisticsStaff(name, level));
            System.out.println( name + " added to Logistic");
            return true;
        }
        else{
            System.out.println("department does not exist, try again");
            System.out.println("Available departments are Human Resource, Finance and Logistic");
            return false;
        }

    }

    public Staff findStaff(Staff staff){
        for(Staff existingStaff: companyStaffList){
            if (existingStaff==staff){
                return existingStaff;
            }
        }
        return null;
    }

    public Staff findStaff(String staffName){
        for(Staff existingStaff: companyStaffList){
            if (existingStaff.getName().equals(staffName)){
                return existingStaff;
            }
        }
        return null;
    }

    public Staff findStaff(String staffName, String department){
        for(Staff existingStaff: companyStaffList){
            if (existingStaff.getName().equals(staffName) && existingStaff.getDepartment().equals(department)){
                return existingStaff;
            }
        }
        System.out.println("No record match");
        return null;
    }

    public int staffSize(){
        return companyStaffList.size();
    }

    public void printStaffList(){
        for(Staff staff: companyStaffList){
            System.out.println("Name : " + staff.getName() + ", department: " +
                    staff.getDepartment() + ", level: " + staff.getLevel() + ", status: "
                    + staff.getEmploymentStatus());
        }
    }

    public boolean updateLevel(String staffName, int level){
        for (Staff staff1 : companyStaffList) {
            if (staff1.getName().equals(staffName)) {
                int oldLevel = staff1.getLevel();
                staff1.setLevel(level+oldLevel);
                return true;
            }
        }
        return false;
    }

    public boolean updateDepartmnet(String staffName, String Dept){
        for(Staff staff1: companyStaffList){
            if (staff1.getName().equals(staffName)){
                staff1.setDepartment(Dept);
                return true;
            }
        }
        return false;
    }


    public boolean updateStaffStatus(String staffName, boolean status){
        for(Staff staff1: companyStaffList){
            if (staff1.getName()==staffName){
                staff1.setEmploymentStatus(status);
                    return true;
                }
            }
        return false;
    }
}
