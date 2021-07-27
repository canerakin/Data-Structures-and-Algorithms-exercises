package com.company;

/**
 * there is branch class
 */
public class Branch {

    /**
     * Office chairs
     */
    private Item[] chairs ;
    /**
     * Office chairs size
     */
    private int ChairsSize = 7 ;
    /**
     * Office desks
     */
    private Item[] desks ;
    /**
     * desks size
     */
    private int DesksSize = 5;
    /**
     * meeting tables
     */
    private Item[] tables ;
    /**
     * tables size
     */
    private int TablesSize = 10 ;
    /**
     * book cases
     */
    private Item[] cases ;
    /**
     * cases size
     */
    private int CasesSize = 12;
    /**
     * Office cabinets
     */
    private Item[] cabinets ;
    /**
     * office cabinets size
     */
    private int CabinetsSize = 12 ;

    /**
     * constructure for fill the branch
     */
    public Branch() {
        int i;
        chairs = new Item[ChairsSize];
        for (i = 0; i < ChairsSize; i++) {
            chairs[i] = new Item("Office chairs", 5);
        }

        desks = new Item[DesksSize];
        for (i = 0; i < DesksSize; i++) {
            desks[i] = new Item("Office desks", 4);
        }

        tables = new Item[TablesSize];
        for (i = 0; i < TablesSize; i++) {
            tables[i] = new Item("Meeting tables", 4);
        }

        cases = new Item[CasesSize];
        for (i = 0; i < CasesSize; i++) {
            cases[i] = new Item("Bookcases", 1);
        }

        cabinets = new Item[CabinetsSize];
        for (i = 0; i < CabinetsSize; i++) {
            cabinets[i] = new Item("Office cabinets", 1);
        }
    }

    /**
     * customer if take a item , program sales and return item name , after take stock
     * @param item is item name
     * @param model is index of which model
     * @param color is index of which color
     * @return item name
     */
    public String sales(String item , int model , int color ) {
        String name =new String();
        name = "-";
        if (item == chairs[model].getModelName()) {
            name = chairs[model].sales(color);
        }
        else if (item == desks[model].getModelName()) {
            name = desks[model].sales(color);
        }
        else if (item == tables[model].getModelName()) {
            name = tables[model].sales(color);
        }
        else if (item == cases[model].getModelName()) {
            name = cases[model].sales(color);
        }
        else if (item == cabinets[model].getModelName()) {
            name = cabinets[model].sales(color);
        }
        return name;
    }

    /**
     * if stock is finish , there check stock
     */
    public void takeStock() {
        int i = 0;
        for (i=0 ; i < ChairsSize ; i++) {
            chairs[i].takeStock();
        }
        for (i=0 ; i < DesksSize ; i++) {
            desks[i].takeStock();
        }
        for (i=0 ; i < TablesSize ; i++) {
            tables[i].takeStock();
        }
        for (i=0 ; i < CasesSize ; i++) {
            cases[i].takeStock();
        }
        for (i=0 ; i < CabinetsSize ; i++) {
            cabinets[i].takeStock();
        }
    }

    /**
     * Show the stock
     */
    public void ShowStock() {
        int i;
        for (i=0 ; i<ChairsSize ; i++) {
            System.out.print("  " + chairs[i].getModelName() + " model " + (i+1) + " have ");
            chairs[i].ShowStock();
            System.out.println(" ");
        }
        for (i=0 ; i<DesksSize ; i++) {
            System.out.print("  " + desks[i].getModelName() + " model " + (i+1) + " have " );
            desks[i].ShowStock();
            System.out.println(" ");
        }
        for (i=0 ; i<TablesSize ; i++) {
            System.out.print("  " + tables[i].getModelName() + " model " + (i+1) + " have ");
            tables[i].ShowStock();
            System.out.println(" ");
        }
        for (i=0 ; i<CasesSize ; i++) {
            System.out.print("  " + cases[i].getModelName() + " model " + (i+1) + " have " );
            cases[i].ShowStock();
            System.out.println(" ");
        }
        for (i=0 ; i<CabinetsSize ; i++) {
            System.out.print("  " + cabinets[i].getModelName() + " model " + (i+1) + " have " );
            cabinets[i].ShowStock();
            System.out.println(" ");
        }
    }
}
