package com.sona.util;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class SonaArrayList implements Iterable<Object> {

    private static final int DEFAULT_CAPITAL = 10;

    private int theSize;

    private Object[] theItems;

    public SonaArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPITAL);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public void ensureCapacity(int newCapital) {
        if (newCapital < theSize)
            return;
        Object[] old = theItems;
        theItems = new Object[newCapital];
        // 将原来的数据cop到新数组中
        if (size() >= 0) System.arraycopy(old, 0, theItems, 0, size());
    }

    public boolean add(Object item) {
        return true;
    }

    public void add(int index, Object item) {
        // 数组长度已经等于了size，扩容
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        if (theSize - index >= 0)
            System.arraycopy(theItems, index, theItems, index + 1, theSize - index);
        theItems[index] = item;
        theSize++;
    }

    public Object remove(int index) {
        Object removeIndex = theItems[index];
        if (size() - index >= 0)
            System.arraycopy(theItems, index + 1, theItems, index, size() - index);
        theSize--;
        return removeIndex;
    }

    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }

    public Object set(int index, Object item) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object old = theItems[index];
        theItems[index] = item;
        return old;
    }

    @Override
    public Iterator<Object> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<Object> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        public void remove() {
            SonaArrayList.this.remove(--current);
        }
    }
}
