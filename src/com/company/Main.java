package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final StaffList companyStaffList = new StaffList("company");
    private static final HRStaff headHR = new HRStaff("Flora",5);
    private static final Vendor vendor = new Vendor("Gap","shoe","7083748291","chicago");
    private static final Vendor vendoro = new Vendor("Gucci","shoe","7083748291","chicago");
    private static final VendorList vendorList = new VendorList("vendorList");
    private static final BankList bankList = new BankList("banks");
    private static final Inventory inventory = new Inventory("Inventory");
    private static final GoodsReceivable goodsReceivable = new GoodsReceivable("goods Receivable");
    private static final AccountReceivable accountReceivable = new AccountReceivable("account Receivable");
    private static final GoodsInTransit goodsInTransit = new GoodsInTransit("goodsInTransit");
    private static final CostofGoods costofGoods = new CostofGoods("costOfGoods");
    private static final Sales sales = new Sales("sales");

    public static void main(String[] args) {

        vendorList.addNewVendor(vendor);
        vendorList.addNewVendor(vendoro);
        Scanner scanner = new Scanner(System.in);
        companyStaffList.addStaff(headHR);
        companyStaffList.addStaff("Richard","Finance",10);
        companyStaffList.addStaff("Rose","Human Resource",10);
        companyStaffList.addStaff("Joshua","Human Resource",10);
        companyStaffList.addStaff("Josh","Logistic",10);
        companyStaffList.addStaff("Michael","Finance",5);
        companyStaffList.addStaff("James Michael","Finance",5);
        companyStaffList.addStaff("Michael James","Logistic",5);
        companyStaffList.addStaff("Richard","Finance",10);
        companyStaffList.addStaff("Michael David","Finance",5);

        companyStaffList.updateLevel("Michael",1);
        companyStaffList.updateLevel("Josh",1);
        companyStaffList.updateStaffStatus("Josh",false);

        bankList.addBank("Access bank", "0017678372","Checking account",250.00);
        bankList.addBank("Access bank", "0017678372","Checking account",250.00);
        bankList.addBank("Access bank", "0017678372","Checking account",2500.00);
        bankList.addBank("Diamond bank", "1017678372","Checking account",1250.00);

        bankList.withdraw("Access bank","0017678372",1000);
        bankList.withdraw("Access bank","0017678372",1000);
        bankList.withdraw("Access bank","0017678372",1000);

        bankList.deposit("Access bank","0017678372",1000);

        inventory.addQuantity("shoe",4.50,vendor,'X',5);
        inventory.removeQuantity("shoe",4.50,vendor,'X',2);
        inventory.addQuantity("shoe",5.50,vendor,'X',5);
        inventory.removeQuantity("shoe",5.50,vendor,'X',1);
        inventory.removeQuantity("shoee",5.50,vendor,'X',1);
        inventory.addQuantity("shoe",4.50,vendoro,'X',5);

        bankList.printBalance("Access bank");

        System.out.println("====");

        makePurchase("Josh",vendor,'X',5,20); //1
        makePurchase("Josh",vendor,'X',15,20);  //2

        addInventory("Josh",vendor,'X',10,20);
        postSales("Josh",vendor,'X',8,20); //4
        postShipment("Josh",vendor,'X',5,20); //5
        postDelivery("Josh",vendor,'X',2,20);  //6

        payCreditor( "vendora","shoe",'X',2,"Access bank","0017678372",20);
        interbank("Access bank", "0017678372",
                "Diamond bank", "1017678372",10050);
        bankList.viewBanksInfo();

        System.out.println("Stock items below:::");
        vendorList.printVendorList();

        companyStaffList.updateDepartmnet("Michael","Human Resource");

        companyStaffList.printStaffList();

        System.out.println("Welcome, your name");
        String scannerStaff = scanner.nextLine();
        if (companyStaffList.findStaff(scannerStaff) == null) {
            System.out.println("Name not found");
            return;
        }
        String staffn = companyStaffList.findStaff(scannerStaff).getDepartment();
        System.out.println(staffn);


        boolean decision =true;
        while (decision) {
            decision=false;
            if (staffn.equals("Finance")) {
                System.out.println("Finance department. Please choice from the listed option. \n"
                        + "0  -- add or update a vendor's details\n"
                        + "1  -- authorize a purchase\n"
                        + "2  -- pay a vendor\n"
                        + "3  -- post sales\n"
                        + "4  -- post cash received\n"
                        + "5  -- add Bank\n"
                        + "6  -- remove bank\n"
                        + "7  -- make bank deposit\n"
                        + "8  -- make withdrawal from bank\n"
                        + "9 -- make inter bank transfer\n");
                String financeChoice = scanner.next();
                switch (financeChoice) {
                    case "0":
                        System.out.println("What vendor are you adding today, please type their full name");
                        String name = scanner.next();
                        System.out.println("product name");
                        String productName = scanner.next();
                        System.out.println("vendor telephone number");
                        String vendorName = scanner.next();
                        System.out.println("vendor address information");
                        String vendorAdd = scanner.next();
                        vendorList.addNewVendor(name, productName, vendorName, vendorAdd);
                        break;
                    case "1":
                        System.out.println("Whose level are you editing today, please type their full name");

                    case "2":
                        System.out.println("Please provide VendorName: ");
                        String vendorMe = scanner.next();
                        System.out.println("Please provide Vendor product: ");
                        String vendorProduct = scanner.next();
                        System.out.println("size: ");
                        char size = scanner.findInLine(".").charAt(0);
                        System.out.println("quantity");
                        int qty = scanner.nextInt();
                        System.out.println("Please provide bank name: ");
                        String bankName = scanner.next();
                        System.out.println("Please bank account number: ");
                        String bankAcctNo = scanner.next();
                        System.out.println("unit price");
                        double price = scanner.nextInt();
                        payCreditor(vendorMe, vendorProduct, size, qty, bankName, bankAcctNo, price);
                        break;
                    case "3":
                        System.out.println("input inventory name");
                        String inventoryName = scanner.nextLine();
                        System.out.println("input vendor name");
                        String vendor = scanner.nextLine();
                        if (vendorList.findVendor(vendor) == null) {
                            System.out.println("vendor not found");
                            return;
                        }
                        Vendor vendior = vendorList.findVendor(vendor);
                        System.out.println("size: ");
                        char inventorySize = scanner.findInLine(".").charAt(0);
                        System.out.println("quantity");
                        int inventoryQty = scanner.nextInt();
                        System.out.println("unit price");
                        double inventoryPrice = scanner.nextInt();
                        postSales(inventoryName, vendior, inventorySize, inventoryQty, inventoryPrice);
                        break;
                    case "4":
                        System.out.println("Vendor name: ");
                        String vendor11 = scanner.nextLine();
                        Vendor salesVendor = vendorList.findVendor(vendor11);
                        System.out.println("quantity");
                        int qtySales = scanner.nextInt();
                        System.out.println("Please provide bank name: ");
                        String bankSales = scanner.next();
                        System.out.println("Please bank account number: ");
                        String salesDepoBank = scanner.next();
                        System.out.println("unit price");
                        double salesPrice = scanner.nextInt();
                        postCashReceipt(salesVendor, qtySales,bankSales, salesDepoBank, salesPrice);
                        break;
                    case "5":
                        System.out.println("Please provide bank name: ");
                        String addName = scanner.next();
                        System.out.println("Please bank account number: ");
                        String addAcctNo = scanner.next();
                        System.out.println("Please provide bank account type: ");
                        String addAcctType = scanner.next();
                        System.out.println("Deposit amount: ");
                        double addIniDeposit = scanner.nextInt();
                        bankList.addBank(addName,addAcctNo,addAcctType,addIniDeposit);
                        break;
                    case "6":
                        System.out.println("Please provide bank name: ");
                        String removeName = scanner.next();
                        System.out.println("Please bank account number: ");
                        String removeAcctNo = scanner.next();
                        bankList.removeBank(removeName,removeAcctNo);
                        break;
                    case "7":
                        System.out.println("Please provide bank name: ");
                        String depoName = scanner.next();
                        System.out.println("Please bank account number: ");
                        String depoAcctNo = scanner.next();
                        System.out.println("Deposit amount: ");
                        double depoDeposit = scanner.nextInt();
                        bankList.deposit(depoName,depoAcctNo,depoDeposit);
                        break;
                    case "8":
                        System.out.println("Please provide bank name: ");
                        String wName = scanner.next();
                        System.out.println("Please bank account number: ");
                        String wAcctNo = scanner.next();
                        System.out.println("Deposit amount: ");
                        double wDeposit = scanner.nextInt();
                        bankList.withdraw(wName,wAcctNo,wDeposit);
                        break;
                    case "9":
                        System.out.println("Please provide withdrawing bank name: ");
                        String from = scanner.next();
                        System.out.println("Please bank withdrawing account number: ");
                        String fromAccountNumber = scanner.next();
                        System.out.println("Please provide depositing bank name: ");
                        String toBankName = scanner.next();
                        System.out.println("Please depositing bank account number: ");
                        String toAccountNumber = scanner.next();
                        System.out.println("transfer amount: ");
                        double transferAmt = scanner.nextInt();
                        interbank(from,fromAccountNumber,toBankName, toAccountNumber, transferAmt);
                        break;
                }
            } else if (staffn.equals("Human Resource")) {
                System.out.println("Human resource department. Please choice from the listed option. \n"
                        + "0  --  Add a new staff\n"
                        + "1  -- update staff level\n"
                        + "2  -- update staff department\n"
                        + "3  -- update staff status\n"
                        + "4  -- view staff list\n");

                String hrChoice = scanner.next();
                label:
                switch (hrChoice) {
                    case "0":
                        System.out.println("Who are you adding today, please type their full name");
                        String name = scanner.next();
                        System.out.println("What department. Please choice from the departments listed  below. \n"
                                + "0 - Finance\n"
                                + "1 - Human Resource\n"
                                + "2 - Logistic");
                        String department = scanner.next();
                        switch (department) {
                            case "0":
                                department = "Finance";
                                break;
                            case "1":
                                department = "Human Resource";
                                break;
                            case "2":
                                department = "Logistic";
                                break;
                            default:
                                System.out.println("wrong input");
                                break label;
                        }
                        System.out.println("Employment level");
                        int level = scanner.nextInt();
                        companyStaffList.addStaff(name, department, level);
                        break;
                    case "1":
                        System.out.println("Whose level are you editing today, please type their full name");
                        String nameEdit = scanner.next();
                        System.out.println(nameEdit);
                        if (companyStaffList.findStaff(nameEdit)!=null) {
                            Staff staffEdit = companyStaffList.findStaff(nameEdit);
                            System.out.println(staffEdit.getName());
                            int oldLevel = staffEdit.getLevel();
                            System.out.println("Employment level increment");
                            int levelEdit = scanner.nextInt();
                            staffEdit.setLevel(levelEdit + oldLevel);
                        }

                        else if(companyStaffList.findStaff(nameEdit)==null){
                        System.out.println("staff not found");
                    }
                        break ;
                    case "2":
                        System.out.println("Whose department are you editing today, please type their full name");
                        String nameDeptEdit = scanner.next();
                        Staff staffDept = companyStaffList.findStaff(nameDeptEdit);
                        if (staffDept==null){
                            System.out.println("staff not found");
                            break;
                        }
                        System.out.println("What department. Please choice from the departments listed  below. \n"
                                + "0 - Finance\n"
                                + "1 - Human Resource\n"
                                + "2 - Logistic");
                        String deptEdit = scanner.next();
                        if (deptEdit.equals("0")){
                            deptEdit = "Finance";
                        }
                        else if (deptEdit.equals("1")){
                            deptEdit = "Human Resource";
                        }
                        else if (deptEdit.equals("2")){
                            deptEdit = "Logistic";
                        }
                        else {
                            System.out.println("wrong input");
                            break;
                        }
                        staffDept.setDepartment(deptEdit);
                        break;
                    case "3":
                        System.out.println("Whose status are you editing today, please type their full name");
                        String nameDeptSt = scanner.next();
                        System.out.println("Please choose from the choices listed  below. \n"
                                + "true or false");
                        boolean statusEdit = scanner.nextBoolean();
                        companyStaffList.updateStaffStatus( nameDeptSt, statusEdit);
                        break;
                    case "4":
                        companyStaffList.printStaffList();
                        break;
                }


            } else if (staffn.equals("Logistic")) {
                System.out.println("Logistic department. Please choice from the listed option. \n"
                        + "0  --  Add inventory\n"
                        + "1  -- post shipment\n"
                        + "2  -- post delivery\n"
                        + "3  -- print inventory list\n"
                        + "4  -- print goods in transit\n"
                        + "5  -- print goods receivable\n"
                        + "6  -- get item price\n");

                String LogicChoice = scanner.next();
                switch (LogicChoice) {
                    case "0":
                        System.out.println("Welcome, Please have available the following information. Inventory name, \n"
                                + "vendor name, size, quantities and unit price");
                        System.out.println("Inventory name: ");
                        String name = scanner.next();
                        System.out.println("Vendor name: ");
                        String vendor = scanner.next();
                        Vendor vendorName = vendorList.findVendor(vendor);
                        System.out.println("size: ");
                        char size = scanner.findInLine(".").charAt(0);
                        System.out.println("quantity received");
                        int qty = scanner.nextInt();
                        System.out.println("unit price");
                        double price = scanner.nextInt();

                        addInventory(name, vendorName, size, qty, price);
                    case "1":
                        System.out.println("Inventory name: ");
                        String postReceiveGood = scanner.next();
                        System.out.println("Vendor name: ");
                        String vendor11 = scanner.nextLine();
                        Vendor vendorNm = vendorList.findVendor(vendor11);
                        if (vendorNm==null){
                            System.out.println("vendor not found");
                            break;
                        }
                        System.out.println("size: ");
                        char sizess = scanner.findInLine(".").charAt(0);
                        System.out.println("quantity received");
                        int qttty = scanner.nextInt();
                        System.out.println("unit price");
                        double prize = scanner.nextInt();
                        postShipment(postReceiveGood, vendorNm, sizess, qttty, prize);
                        break;
                    case "2":
                        System.out.println("Inventory name: ");
                        String postDeliveredGood = scanner.next();
                        System.out.println("Vendor name: ");
                        String vendor19 = scanner.next();
                        Vendor vendorm = vendorList.findVendor(vendor19);
                        System.out.println("size: ");
                        char sizss = scanner.findInLine(".").charAt(0);
                        System.out.println("quantity received");
                        int qtttyy = scanner.nextInt();
                        System.out.println("unit price");
                        double prirze = scanner.nextInt();
                        postDelivery(postDeliveredGood, vendorm, sizss, qtttyy, prirze);
                        break;
                    case "3":
                        inventory.printVendorPerUnitCost();
                        break;
                    case "4":
                        goodsInTransit.getTotalStockValue();
                        break;
                    case "5":
                        goodsReceivable.printVendorPerUnitCost();
                        break;
                    case "6":
                        System.out.println("Inventory item: ");
                        String inventoryItemPrice = scanner.next();
                        inventory.getPrice(inventoryItemPrice);
                        break;
                }
            } else {
                System.out.println("Name does not exist on record");
                break;
            }
            System.out.println("           ");
            decision=true;
        }
    }

    public static void makePurchase(String name, Vendor vendorName, char size, int Qty, double price){
        if (vendorList.addToExistingVendor(vendorName,price,Qty)) {
            goodsReceivable.addQuantity(name, price, vendorName, size, Qty);
        } else {
            System.out.println("transaction failed, vendor not found");
        }
    }

    public static void payCreditor(String name, String product, char size, int Qty,String bankName, String bankAcctNo, double price){
        if (bankList.findBank(bankName,bankAcctNo).getBalance()>=Qty*price && vendorList.findVendor(name, product)!=null) {
            vendorList.removeExistingBalance(name,product,price,Qty);
            bankList.withdraw(bankName,bankAcctNo, price*Qty);
        } else {
            System.out.println("transaction failed, vendor not found");
        }
    }

    public static void addInventory(String name, Vendor vendorName, char size, int Qty, double price){
        if (goodsReceivable.findStock(name,price,vendorName)!=null) {
            inventory.addQuantity(name,price,vendorName,size,Qty);
            goodsReceivable.removeQuantity(name,price,vendorName,size,Qty);
        } else {
            System.out.println("transaction failed, vendor not found");
        }
    }

    public static void postShipment(String name, Vendor vendorName, char size, int Qty, double price){
        if (inventory.findStock(name,price,vendorName).getStockQtyBySize(size)>=Qty) {
            goodsInTransit.addQuantity(name,price,vendorName,size,Qty);
            inventory.removeQuantity(name,price,vendorName,size,Qty);
        } else {
            System.out.println("transaction failed, vendor not found or not quantity");
        }
    }

    public static void postDelivery(String name, Vendor vendorName, char size, int Qty, double price){
        if (goodsInTransit.findStock(name,price,vendorName).getStockQtyBySize(size)>=Qty) {
            costofGoods.addQuantity(name,price,vendorName,size,Qty);
            goodsInTransit.removeQuantity(name,price,vendorName,size,Qty);
        } else {
            System.out.println("transaction failed, vendor not found or not quantity");
        }
    }

    public static void postSales(String name, Vendor vendorName, char size, int Qty, double price){
            if (inventory.findStock(name,price,vendorName)!=null) {
                sales.addToExistingVendor(vendorName,price*1.75,Qty);
                accountReceivable.addToExistingVendor(vendorName,price*1.75,Qty);

            } else {
                System.out.println("transaction failed, vendor not found");
            }
    }

    public static boolean postCashReceipt(Vendor vendorName, int Qty,String bankName, String bankAcctNo, double price){
        if (bankList.findBank(bankName,bankAcctNo)!=null && accountReceivable.findVendor(vendorName)!=null) {
            bankList.deposit(bankName,bankAcctNo, price*Qty);
            accountReceivable.removeExistingBalance(vendorName,price,Qty);
            return true;
        } else {
            System.out.println("transaction failed, vendor not found");
            return false;
        }
    }

    public static void interbank(String from, String fromAccountNumber,String toBankName, String toAccountNumber, double transferAmt){
        Bank withdrawingBank = bankList.findBank(from, fromAccountNumber);
        Bank depositBank = bankList.findBank(toBankName, toAccountNumber);
        if (withdrawingBank !=null && depositBank !=null){
            if(bankList.withdraw(from,fromAccountNumber,transferAmt)) {
                bankList.deposit(toBankName,toAccountNumber,transferAmt);
            }
        }else {
            System.out.println("interbank transfer failed");
        }
    }
}




