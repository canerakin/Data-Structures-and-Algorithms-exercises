package com.company;

/**
 * item ( esya ) class
 */
public class Item {

    /**
     * Model name
     */
    private String ModelName = new String();

    /**
     * item color size
     */
    private int color[];

    /**
     * how many color
     */
    private int size = 0;

    /**
     * constructure
     */
    public Item() {
        ModelName = "";
        color = new int[1];
        size = 0;
    }

    /**
     * parameter constructure
     * @param ModelName is model name
     * @param color is color size
     */
    public Item(String ModelName,int color) {
        int i;
        this.ModelName = ModelName;
        this.color = new int[color];
        this.size = color;
        for (i=0 ; i < size ; i++) {
            this.color[i] = 1;
        }
    }

    /**
     * actual methods
     * @return item name
     */
    public String getModelName(){ return ModelName; }

    /**
     * How many colors have return
     * @return
     */
    public int getSize() { return size;}

    /**
     * which color have stok
     * @param size is which color
     * @return stock of color
     */
    public int getStock(int size) { return this.color[size]; }

    /**
     * if customer buy a new item , there sales
     * @param index
     * @return
     */
    public String sales(int index) {
        this.color[index] -= 1;
        return ModelName + " \n" ;
    }

    /**
     *  İf store is finish , take it for sales
     */
    public void takeStock() {
        int i;
        for (i=0 ; i < size ; i++) {
            if (color[i] == 0)
            {
                System.out.print("  color" + (i+1) + " finish in stock and take it in branch" );
                color[i] += 1;
            }
        }
    }

    /**
     * Print output for all items stock
     */
    public String ShowStock() {
        int i;
        for (i = 0; i < size; i++) {
            System.out.print("  color" + (i+1) + "->stock:" + color[i]);
        }
        return "";
    }
}
