package com.company;

public class HRStaff extends Staff {
//     ArrayList<String> Transactions;

    public HRStaff(String name, int level) {
        super(name, "Human Resource", level);
//        Transactions = new  ArrayList<String>();
    }

    public int getStaffID(Staff staff){
       return staff.getStaffID();
    }



    @Override
    public void setStaffEmploymentStatus(Staff staff1, boolean bool){
        Staff staff = staff1;
        boolean oldstatus = staff1.getEmploymentStatus();
        staff.setStaffEmploymentStatus(staff, bool);
        String transaction = this.getName() + " altered the  employment status of  employee: "
                + staff1.getName() + " from " + oldstatus + " to " + bool;
        this.getTransactions().add(transaction);
    }


}
