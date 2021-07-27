package com.company;

/**
 * Employee class
 */
public class Branch_Employee extends Person implements Research_Stock{
    /**
     * Employee constructure
     */
    public Branch_Employee(){
        super();
    }

    /**
     * constructure
     * @param name is employee name
     * @param surname is employee surname
     */
    public Branch_Employee(String name,String surname){
        super(name,surname);
    }

    /**
     * actual methods
     * @return employee name
     */
    public String getName() { return super.getName(); }

    /**
     * actual methods
     * @return employee surname
     */
    public String getSurname() { return super.getSurname(); }

    /**
     * if employee want to take stock or look for finish
     * @param branches is all branch
     * @param branchSize is index of branch
     */
    public void takeStock(Branch[] branches , int branchSize) {
        try {
            int i;
            for (i=0 ; i<branchSize ; i++) {
                branches[i].takeStock();
            }
            System.out.println(" Now Branch Stock is FULL . \n");
        }catch (Exception e) {
            System.out.println("if send a false parameter");
        }
    }

    /**
     * Branch employee sales goods
     * @param customer is all customer
     * @param branches is all branch
     * @param branchSize is index of branches
     * @param goods is goods name
     * @param item is goods index
     * @param color is which color
     */
    public void shopping(Customer customer,Branch[] branches, int branchSize , String goods , int item ,int color){
        try {
            int i , flag = 0;
            String sales_name;
            for (i=0;i<branchSize;i++){
                if ( (branches[i].sales(goods,item,color) != "-" ) && flag == 0){
                    sales_name = branches[i].sales(goods,item,color);
                    customer.setLastStore(sales_name);
                    System.out.println(customer.getName() + " " + customer.getSurname() + " take a " + sales_name);
                    flag = 1;
                }
            }

        }catch (Exception e){
            System.out.println("İf Branch not find this goods");
        }

    }

    /**
     * print the last shopping
     * @param customer is which costomer
     */
    public void last_Shopping(Customer customer){
        try {
            System.out.println(customer.getName() + " " + customer.getSurname() + " last shopping : ");
            System.out.println(customer.getLastStore());
        }catch (Exception e) {
            System.out.println("İf Branch not find this goods");
        }
    }

}
