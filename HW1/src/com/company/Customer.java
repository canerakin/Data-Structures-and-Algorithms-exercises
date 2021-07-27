package com.company;

/**
 * Customer class
 */
public class Customer extends Person{
    /**
     * customer e_mail
     */
    private String Email = new String();

    /**
     * customer password
     */
    private int Password ;

    /**
     * customer special_number
     */
    private int Special_Number ;

    /**
     * customer address
     */
    private String Address = new String();

    /**
     * Customer Number
     */
    private String Number = new String();

    /**
     * Last store taked
     */
    private String LastStore = new String();

    /**
     * admin constructure
     */
    public Customer(){
        super();
        Email = "";
        Password = 0;
        Special_Number = 0;
        Address = "" ;
        Number = "" ;
        LastStore = "" ;
    }

    /**
     * Constructure
     * @param name is customer name
     * @param surname is customer surname
     * @param Email is customer e-mail
     * @param Password is customer password
     * @param Special_Number is customer special number
     */
    public Customer(String name , String surname , String Email , int Password ,int Special_Number ){
        super(name,surname);
        this.Email = Email;
        this.Password = Password;
        this.Special_Number = Special_Number;
        Address = "" ;
        Number = "" ;
        LastStore = "" ;
    }

    /**
     * actual methods
     * @return Customer name
     */
    public String getName(){
        return super.getName();
    }

    /**
     * actual methods
     * @return Customer surname
     */
    public String getSurname(){
        return super.getSurname();
    }

    /**
     * actual methods
     * @return e-mail
     */
    public String getEmail() { return this.Email; }

    /**
     * actual methods
     * @return password
     */
    public int getPassword() { return this.Password; }

    /**
     * actual methods
     * @return Special number
     */
    public int getSpecial_Number() {return this.Special_Number ;}

    /**
     * Take address
     * @param address is input customer address
     */
    public void setAddress(String address) {
        Address = address;
    }

    /**
     * Take customer number
     * @param number is input phone number
     */
    public void setNumber(String number) {
        Number = number ;
    }

    /**
     * İf customer wants to see last store
     * @param Store is last store
     */
    public void setLastStore(String Store) {
        LastStore += "\n" ;
        LastStore += Store ;
    }

    /**
     * if need seeing last store
     * @return all store by customer
     */
    public String getLastStore() { return LastStore ; }


}
