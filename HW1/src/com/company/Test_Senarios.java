package com.company;

/**
 *  Caner AKIN
 */
public class Test_Senarios {
    /**
     * for a only test senarios
     */
    public Test_Senarios() {
        System.out.println("\nTest senarios is Start!\n");

        Company company = new Company();

        /* Company open a new branch and remove a branch*/
        company.removeBranch(3);
        company.removeBranch(0);
        company.removeBranch(1);
        company.addBranch();
        company.ShowStock();

        /* Administrator take a new branch employee  */
        company.addEmployee("Furkan" , "Aydin" );

        /* Administrator look stock */
        company.Admin_takeStock();

        /* Administrator look stock */
        company.Employees_takeStock();

        /* Create a new customer*/
        company.takeCustomer("ilker","AY","asd@gtu.edu.tr",270,"çayırova","542");

        /* Start shopping*/
        company.shopping("ilker","AY",270,"Office chairs",1,4);
        company.shopping("ilker","AY",270,"Office desks",2,1);
        company.shopping("ilker","AY",270,"Meeting tables",1,3);

        /* See last shopping*/
        company.ask_LastShopping("ilker","AY",270);

        System.out.println("\nTest senarios is finish!");
    }
}