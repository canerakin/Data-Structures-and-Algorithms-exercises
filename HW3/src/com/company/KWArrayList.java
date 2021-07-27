package com.company;

import java.util.Arrays;

/**
 * KWArrayList implementation
 * @param <E>
 */
public class KWArrayList<E> {
    /**
     * need capacity
     */
    private static final int INITIAL_CAPACITY = 10;
    /**
     * Keep data in array
     */
    private E[] theData;
    /**
     * size is how many index have
     */
    private int size = 0;
    /**
     * is have capacity
     */
    private int capacity = 0;

    /**
     * Constructor
     */
    public KWArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }

    /**
     * need size getter method
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * add a element
     * @param anEntry is data
     * @return the if can added
     */
    public boolean add(E anEntry) {
        if(size == capacity) {
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    /**
     * add element in a index
     * @param index is location
     * @param anEntry is data type
     */
    public void add(int index, E anEntry) {
        if(index<0 || index>=size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(size == capacity) {
            reallocate();
        }
        for(int i=size; i>index; i--) {
            theData[i] = theData[i-1];
        }
        theData[index] = anEntry;
        size++;
    }

    /**
     * if need data in index
     * @param index is location of data
     * @return the data
     */
    public E get(int index) {
        if(index<0 || index>=size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /**
     * if add a element in index
     * @param index
     * @param newValue
     * @return
     */
    public E set(int index, E newValue) {
        if(index<0 || index>=size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    /**
     * if remove element in a index
     * @param index is location of data
     * @return the deleted data
     */
    public E remove(int index) {
        if(index<0 || index>=size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for(int i=index+1; i<size; i++) {
            theData[i-1] = theData[i];
        }
        size--;
        return returnValue;
    }

    /**
     * if capacity is full , need new memory
     */
    private void reallocate() {
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
    }

}
