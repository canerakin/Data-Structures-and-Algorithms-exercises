package com.company;

/**
 * Administrator class
 */
public class Administrator extends Person implements Research_Stock{
    /**
     * admin constructure
     */
    public Administrator(){
        super();
    }

    /**
     * constructure
     * @param name is admin name
     * @param surname is admin surname
     */
    public Administrator(String name , String surname){
        super(name,surname);
    }

    /**
     * actual methods
     * @return admin name
     */
    public String getName(){
        return super.getName();
    }

    /**
     * actual methods
     * @return admin surname
     */
    public String getSurname(){
        return super.getSurname();
    }

    /**
     * Admin can add a new branch
     * @param branches is all branch
     * @param branchSize is branch size
     */
    public void addBranch(Branch[] branches ,int branchSize){
        try {
            int i;
            Branch[] addBranch = new Branch[branchSize + 1];
            for (i = 0; i < branchSize; i++) {
                addBranch[i] = branches[i];
            }
            addBranch[branchSize] = new Branch();
            branches = addBranch;
            System.out.println("---> Administrator add a new Branch ");
        }catch (Exception e) {
            System.out.println("if send a false parameter");
        }
    }

    /**
     * Admin can delete a branch
     * @param branches is all branch
     * @param branchSize is how many branch
     * @param whichBranch is deleted branch index
     */
    public void removeBranch(Branch[] branches , int branchSize , int whichBranch){
        try {
            int i,j=0;
            Branch[] deleteBranch = new Branch[branchSize-1];
            for (i=0 ; i<branchSize ; i++) {
                if (i != whichBranch) {
                    deleteBranch[j] = branches[i];
                    j += 1;
                }
            }
            branches = deleteBranch;
            System.out.println("\n ---> Administrator closed Branch " + (whichBranch+1) );
        }catch (Exception e) {
            System.out.println("if send a false parameter");
        }
    }

    /**
     * İf administrator take a new employee , there
     * @param employees is branch employee
     * @param employeeSize is how many worker have
     * @param name is employees name
     * @param surname is employees surname
     */
    public void addEmployee(Branch_Employee[] employees ,int employeeSize , String name , String surname){
        try {
            int i;
            Branch_Employee[] addEmployee = new Branch_Employee[employeeSize+1];
            for (i= 0;i<employeeSize;i++) {
                addEmployee[i] = employees[i];
            }
            addEmployee[employeeSize] = new Branch_Employee(name,surname);
            employees = addEmployee;
            System.out.println("\n ---> Administrator add a new Branch Employee is :" + employees[employeeSize].getName() + " " + employees[employeeSize].getSurname() + " \n");
        }catch (Exception e) {
            System.out.println("if send a false parameter");
        }
    }

    /**
     * if administrator remove the employee
     * @param employees is branch employee
     * @param employeeSize is how many worker have
     * @param whichEmployee is index of remove employee
     */
    public void removeEmployee(Branch_Employee[] employees , int employeeSize , int whichEmployee){
        try {
            int i,j=0;
            System.out.println("\n---> Administrator remove Branch Employee is : " + employees[whichEmployee].getName() + " " + employees[whichEmployee].getSurname() );
            Branch_Employee[] deleteEmployee = new Branch_Employee[employeeSize-1];
            for (i=0 ; i<employeeSize ; i++) {
                if (i != whichEmployee) {
                    deleteEmployee[j] = employees[i];
                    j += 1;
                }
            }
            employees = deleteEmployee;
        }catch (Exception e) {
            System.out.println("if send a false parameter");
        }
    }

    /**
     * if administrator want to take stock or look for finish
     * @param branches is all branches
     * @param branchSize is size of branch
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


}
