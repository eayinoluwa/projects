package com.company;

public class Staff {
    private static int IDcounter= 0000;
    private int staffID;
    private String name;
    private String department;
    private int level;
    private boolean employmentStatus;

    public Staff(String name, String department, int level) {
        nameBuilder(name);
        this.department = department;
        this.level = level;
        IDcounter++;
        this.staffID = IDcounter;
        employmentStatus = true;
    }

    public void nameBuilder(String name){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<name.length();i++){
            sb.append(name.charAt(i));
        }
        this.name = sb.toString();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (staffID != staff.staffID) return false;
        if (level != staff.level) return false;
        if (employmentStatus != staff.employmentStatus) return false;
        if (!name.equals(staff.name)) return false;
        return department.equals(staff.department);
    }

    @Override
    public int hashCode() {
        int result = staffID;
        result = 31 * result + name.hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + level;
        result = 31 * result + (employmentStatus ? 1 : 0);
        return result;
    }
}
