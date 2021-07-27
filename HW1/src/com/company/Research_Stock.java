package com.company;

/**
 *  Administrator and Branch employee use this interface
 */
public interface Research_Stock {
    /**
     * This function work for take stock
     * @param branches is all branch
     * @param branchSize is index of all branch
     */
    public void takeStock(Branch[] branches , int branchSize);
}
