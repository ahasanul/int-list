package org.test.ilist;

import java.util.Iterator;

/**
 * Created by shaque on 4/7/2017.
 */
public class IntSingleLinkedList implements Iterable<Integer> {
    private Integer[] intArray;
    //protected int length = 0;
    private int currentIndex = 0;

    IntSingleLinkedList(int listSize) {
        intArray = new Integer[listSize];
    }

    /**
     * Append an Element
     * @param item
     */
    public void append(Integer item) {
        intArray[currentIndex++] = item;
    }

    public int size() {
        return currentIndex;
    }

    /**
     * Remove and Return the Last Item
     * @return
     */
    public Integer pop() {
        currentIndex--;
        return intArray[currentIndex];
    }

    /**
     * Remove Elements which are greater than a targeted value
     * @param targetVal
     */
    public void removeItemsGreaterThan(int targetVal) {
        Integer[] tmpArray = new Integer[intArray.length];
        int tmpIndex = 0;
        for (int i = 0; i < currentIndex; i++) {
            if (!(intArray[i] > targetVal)) {
                tmpArray[tmpIndex++] = intArray[i];
            }
        }
        intArray = tmpArray;
        currentIndex = tmpIndex;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> itemIterator = new Iterator<Integer>() {
            private int idx = 0;

            @Override
            public boolean hasNext() {
                return idx < currentIndex && intArray[idx] != null;
            }

            @Override
            public Integer next() {
                return intArray[idx++];
            }

            @Override
            public void remove() {
                // Not Implemented
            }
        };
        return itemIterator;
    }

    public static void main (String[] args) {

        IntSingleLinkedList iLists = new IntSingleLinkedList(100);

        iLists.append(5);
        System.out.println("List Size: " + iLists.size());

        iLists.append(6);
        System.out.println("List Size: " + iLists.size());

        System.out.println("Last Element Removed: " + iLists.pop() + " List Size: " + iLists.size());

        iLists.append(8);
        System.out.println("List Size: " + iLists.size());

        iLists.append(7);
        System.out.println("List Size: " + iLists.size());

        iLists.removeItemsGreaterThan(6);
        System.out.println("List Size: " + iLists.size());

        System.out.println("*** All Items Start ***");
        for (Integer iList: iLists) {
            System.out.println("List Item: " + iList);
        }
        System.out.println("*** All Items End ***");
    }
}
