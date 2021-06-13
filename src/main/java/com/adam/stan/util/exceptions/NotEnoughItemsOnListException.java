package com.adam.stan.util.exceptions;

import com.adam.stan.util.RandomItemsFromList;

/**
 * Should be thrown by {@link RandomItemsFromList}
 * 
 * @author adam
 *
 */
public class NotEnoughItemsOnListException extends Exception {
    private static final long serialVersionUID = 7483649114262446680L;

    private int itemsOnList;
    private int howManyItemsToChoose;

    public NotEnoughItemsOnListException(String message, int itemsOnList, int howManyItemsToChoose) {
        super(message);
        this.itemsOnList = itemsOnList;
        this.howManyItemsToChoose = howManyItemsToChoose;
    }

    public int getItemsOnList() {
        return itemsOnList;
    }

    public int getHowManyItemsToChoose() {
        return howManyItemsToChoose;
    }

}
