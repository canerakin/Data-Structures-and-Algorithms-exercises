package com.company;
import java.util.Scanner;

/**
 * test senarios
 */
public class Test_Senarios {
    /**
     * driver function
     */
    public void Driver(){
        System.out.println("DRİVER START \n");
        Company company = new Company();
        Scanner input = new Scanner(System.in);
        int flag = 1;
        try {
            while (flag == 1) {
                System.out.print("Menu: \n " + "Login Administrator Press 1 \n " +
                        "Login Branch Employee Press 2\n " + "Login Customer Press 3\n " +
                        "Exit Press 0\n >>");
                int user = input.nextInt();

                switch (user){
                    case 1:
                        Admin(company);
                        break;
                    case 2:
                        System.out.println("Employees Look Stock");
                        company.Employees_takeStock();
                        break;
                    case 3:
                        Customr(company);
                        break;
                    case 0:
                        flag = 0;
                        break;
                    default:
                        System.out.println("İnput not in menu , try again !!!");
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("\n\n   -------False İnput---------   \n");
        }
    }

    /**
     * Administrator methods
     * @param company is all system
     */
    public void Admin(Company company)
    {
        System.out.print("Administrator Menu: \n " + "Add Branch Press 1 \n " +
                "Remove Branch Press 2\n " + "Show Stock Press 3\n " + "Take employee Press 4\n " +
                "Take Stock 5\n ");
        Scanner input = new Scanner(System.in);
        int user = input.nextInt();
        try {

            switch (user){
                case 1:
                    System.out.println("Open a new Branch");
                    company.addBranch();
                    break;
                case 2:
                    System.out.print("Which branch index : ");
                    int index = input.nextInt();
                    company.removeBranch(index);
                    break;
                case 3:
                    company.ShowStock();
                    break;
                case 4:
                    System.out.println("Enter employee name : ");
                    String name = input.nextLine();
                    System.out.println("Enter employee surname : ");
                    String surname = input.nextLine();
                    company.addEmployee(name,surname);
                    break;
                case 5:
                    company.Admin_takeStock();
                    break;
                default:
                    System.out.println("İnput not in menu , try again !!!");
                    break;
            }
        }catch (Exception e){
            System.out.println("\n\n   -------False İnput---------   \n");
        }
    }

    /**
     * customer login there
     * @param company is all system
     */
    public void Customr(Company company)
    {
        System.out.print("Customer Menu: \n " + "Add Customer Press 1 \n " +
                "Shopping Press 2\n " + "Ask last shopping Press 3\n ");
        Scanner input = new Scanner(System.in);
        int user = input.nextInt();
        try
        {
            switch (user){
                case 1:
                    System.out.print("Enter name : ");
                    String name = input.nextLine();
                    System.out.print("Enter surname : ");
                    String surname = input.nextLine();
                    System.out.print("Enter mail : ");
                    String mail = input.nextLine();
                    System.out.print("Enter password : ");
                    int password = input.nextInt();
                    System.out.print("Enter adress : ");
                    String adress = input.nextLine();
                    System.out.print("Enter phone : ");
                    String phone = input.nextLine();
                    company.takeCustomer(name,surname,mail,password,adress,phone);
                    break;
                case 2:
                    System.out.print("Enter name : ");
                    String names = input.nextLine();
                    System.out.print("Enter surname : ");
                    String surnames = input.nextLine();
                    System.out.print("Enter password : ");
                    int passwords = input.nextInt();
                    System.out.print("Enter goods : ");
                    String adres = input.nextLine();
                    System.out.print("Enter item : ");
                    int item = input.nextInt();
                    System.out.print("Enter color : ");
                    int color = input.nextInt();
                    company.shopping(names,surnames,passwords,adres,item,color);
                    break;
                case 3:
                    System.out.print("Enter name : ");
                    String name_ = input.nextLine();
                    System.out.print("Enter surname : ");
                    String surname_ = input.nextLine();
                    System.out.print("Enter password : ");
                    int password_ = input.nextInt();
                    company.ask_LastShopping(name_,surname_,password_);
                    break;
                default:
                    System.out.println("İnput not in menu , try again !!!");
                    break;
            }
        }catch (Exception e){
            System.out.println("\n\n   -------False İnput---------   \n");
        }
    }
}
