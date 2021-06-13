package com.adam.stan.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.adam.stan.util.exceptions.NotEnoughItemsOnListException;

public class RandomItemsFromList<E> {
    private int numberOfItems;
    private List<E> elements;

    public RandomItemsFromList(int numberOfElements, List<E> objects) {
        numberOfItems = numberOfElements;
        elements = objects;
    }

    public List<E> getRandomItems() throws NotEnoughItemsOnListException {
        if (elements.size() < numberOfItems) {
            throw new NotEnoughItemsOnListException("Too less elements on the list", elements.size(), numberOfItems);
        }
        List<E> aFewOfThem = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numberOfItems; i++) {
            int index = random.nextInt(elements.size());
            E element = elements.get(index);
            elements.remove(index);
            aFewOfThem.add(element);
        }
        return aFewOfThem;
    }
}
