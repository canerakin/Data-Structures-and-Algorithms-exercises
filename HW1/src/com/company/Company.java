package com.company;

/**
 * Company otomasyon system class
 */
public class Company {
    /**
     * branches defined
     */
    private Branch[] branches;
    /**
     * Company take admin
     */
    private Administrator[] administrators ;
    /**
     * Company take employees
     */
    private Branch_Employee[] employees;

    /**
     * customer class using
     */
    private Customer[] customers;

    /**
     * Take how many branch
     */
    private int brancheSize = 4;

    /**
     * Take how many admin
     */
    private int adminSize = 1;

    /**
     * Take how many branch employee
     */
    private int employeeSize = 1;

    /**
     * Size of how many customer
     */
    private int customerSize = 0;

    /**
     * Constructure
     */
    public Company() {
        int i;
        branches = new Branch[brancheSize];
        for (i=0 ; i < brancheSize ; i++) {
            branches[i] = new Branch();
        }
        administrators = new Administrator[adminSize];
        administrators[0] = new Administrator("Fatih","Oguz");

        employees = new Branch_Employee[employeeSize];
        employees[0] = new Branch_Employee("Caner","Akin");
    }

    /**
     * Administrator add a new branch
     */
    public void addBranch(){
        administrators[adminSize-1].addBranch(branches,brancheSize);
        brancheSize += 1;
    }

    /**
     * Administrator remove the branch
     * @param index is index of deleted branchs
     */
    public void removeBranch(int index) {
        administrators[adminSize-1].removeBranch(branches,brancheSize,index);
        brancheSize -= 1;
    }

    /**
     * Administrator add a employee
     * @param name is employee name
     * @param surname is employee surname
     */
    public void addEmployee(String name,String surname) {
        administrators[adminSize-1].addEmployee(employees , employeeSize , name , surname);
        employeeSize += 1;
    }

    /**
     * Administrator remove the branch employee
     * @param index is which employee
     */
    public void removeEmployee(int index) {
        administrators[adminSize-1].removeEmployee(employees ,employeeSize ,index);
        employeeSize -= 1;
    }

    /**
     * See name and surname of branch employees
     */
    public void seeEmployees() {
        int i = 0;
        System.out.println("Employees : ");
        for (i = 0; i < employeeSize ; i++) {
            System.out.println(" " + (i+1) + ". employee : " + employees[i].getName() + " " + employees[i].getSurname());
        }
    }

    /**
     * Print all Branch and all item
     */
    public void ShowStock() {
        int i;
        for (i=0; i<brancheSize ; i++) {
            System.out.println("Branch " + (i+1) + " Stock :");
            branches[i].ShowStock();
        }
    }

    /**
     * Admin look stock and if finish some items , take it
     */
    public void Admin_takeStock() {
        System.out.println("Administrator look at the stock");
        administrators[adminSize-1].takeStock(branches,brancheSize);
    }

    /**
     * Employee look stock and if finish some items , take it
     */
    public void Employees_takeStock() {
        System.out.println("Branch Employees look at the stock");
        employees[0].takeStock(branches,brancheSize);
    }

    /**
     * if customer want to create account , the in company
     * @param name customer name
     * @param surname customer surname
     * @param e_mail customer e-mail
     * @param password customer password
     * @param adress customer adress
     * @param phone customer phone
     */
    public void takeCustomer(String name,String surname,String e_mail,int password,String adress,String phone){
        try {
            int i;
            Customer[] create = new Customer[customerSize + 1];
            for (i = 0; i < customerSize; i++) {
                create[i] = customers[i];
            }
            create[customerSize] = new Customer(name, surname, e_mail, password, i);
            create[customerSize].setAddress(adress);
            create[customerSize].setNumber(phone);
            customerSize += 1;
            customers = create;
            System.out.println("New Customer " + customers[customerSize - 1].getName() + " " + customers[customerSize - 1].getSurname() + " in a Branch");
        }catch (Exception e){
            System.out.println("if customer false input");
        }
    }

    /**
     * İf customer trying shopping , branch employee help company
     * @param name customer name
     * @param Surname customer surname
     * @param password customer password
     * @param goods is which goods
     * @param item is which model
     * @param color is which color
     */
    public void shopping(String name , String Surname , int password , String goods , int item ,int color){
        try {
            int i;
            for (i = 0; i < customerSize; i++) {
                if ((customers[i].getName() == name) && (customers[i].getSurname() == Surname)   ) {
                    if (customers[i].getPassword() == password){
                        employees[0].shopping(customers[i],branches,brancheSize,goods,item,color);
                    }
                    else if (customers[i].getPassword() != password){
                        System.out.println("False input of password");
                    }

                }
            }
        }catch (Exception e){
            System.out.println("if not account to employee and try to shopping");
        }
    }

    /**
     * if branch employee want to see customer last shopping
     * @param name is customer name
     * @param Surname is customer surname
     * @param password is customer password
     */
    public void ask_LastShopping(String name , String Surname , int password) {
        try {
            int i;
            for (i = 0; i < customerSize; i++) {
                if ((customers[i].getName() == name) && (customers[i].getSurname() == Surname)   ) {
                    if (customers[i].getPassword() == password){
                        employees[0].last_Shopping(customers[i]);
                    }
                    else if (customers[i].getPassword() != password){
                        System.out.println("False input of password");
                    }

                }
            }
        }catch (Exception e){
            System.out.println("if not account to employee and try to shopping");
        }
    }

}
