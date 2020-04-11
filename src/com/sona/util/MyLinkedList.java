package com.sona.util;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList implements Iterable<AnyType> {


    public MyLinkedList() {
        clear();
    }

    public void clear() {
        // 这里获取不到end节点
        beginMarker = new Node<>(null, null, null);
        // end节点
        endMarker = new Node<>(null, beginMarker, null);
        // 开始节点下面是end节点
        beginMarker.next = endMarker;
        theSize = 0;
        modCount = 0;
    }

    private int theSize;

    private int modCount;

    private Node<AnyType> beginMarker;

    private Node<AnyType> endMarker;


    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private static class Node<AnyType> {

        public Node(AnyType data, Node<AnyType> prex, Node<AnyType> next) {
            this.data = data;
            this.prex = prex;
            this.next = next;
        }

        private AnyType data;

        private Node<AnyType> prex;

        private Node<AnyType> next;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public boolean add(AnyType data) {
        add(size(), data);
        return false;
    }

    public void add(int index, AnyType data) {
        addBefore(getNode(index), data);
    }

    public AnyType get(int index) {
        return getNode(index).data;
    }


    public AnyType set(int index, AnyType data) {
        Node<AnyType> p = getNode(index);
        AnyType old = p.data;
        p.data = data;
        return old;
    }


    public AnyType remove(int index) {
        return remove(getNode(index));
    }

    private Node<AnyType> getNode(int index) {
        Node<AnyType> p;
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = endMarker.prex;
            for (int i = size(); i > index; i--) {
                p = p.prex;
            }
        }
        return p;
    }

    public AnyType remove(Node<AnyType> pow) {
        // 当前节点后面的节点等于等钱节点前面节点的后
        pow.prex.next = pow.next;
        pow.next.prex = pow.prex;
        theSize--;
        modCount--;
        return pow.data;
    }


    // 增加在p的前面
    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<>(x, p.prex, p);
        newNode.prex.next = newNode;
        p.prex = newNode;
        theSize++;
        modCount++;
    }


    private class LinkedListIterator implements Iterator<AnyType> {

        private Node<AnyType> current = beginMarker.next;

        private int expectedModCount = modCount;

        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public AnyType next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;

            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.next);
            okToRemove = false;
            expectedModCount++;
        }
    }


}
