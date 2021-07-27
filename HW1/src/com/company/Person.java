package com.company;

/**
 * Person have a name and surname
 */
public abstract class Person {
    /**
     * Name is person name
     */
    private String Name = new String();
    /**
     * Surname is person surname
     */
    private String Surname = new String();

    /**
     * No parameter Constructure
     */
    public Person(){
        /* this.Name = "" ;
           this.Surname = "" ; */
    }

    /**
     *
     * @param name is person name
     * @param surname is person surname
     */
    public Person(String name , String surname) {
        this.Name = name;
        this.Surname = surname;

    }

    /**
     * actual methods
     * @return Person name
     */
    public String getName() { return Name; }

    /**
     * actual methods
     * @return Person Surname
     */
    public String getSurname() { return Surname ;}


}
