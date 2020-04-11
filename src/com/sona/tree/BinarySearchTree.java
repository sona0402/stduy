package com.sona.tree;

import java.util.NoSuchElementException;

public class BinarySearchTree {

    public static class BinaryNode<T> {

        public BinaryNode(T node) {
            this(node, null, null);
        }

        public BinaryNode(T treeAnyType, BinaryNode<T> left, BinaryNode<T> right) {
            this.treeAnyType = treeAnyType;
            this.left = left;
            this.right = right;
        }

        T treeAnyType;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public T getTreeAnyType() {
            return treeAnyType;
        }

        public void setTreeAnyType(T treeAnyType) {
            this.treeAnyType = treeAnyType;
        }
    }

    // 跟节点
    private BinaryNode<TreeAnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(TreeAnyType treeAnyType) {
        return contains(treeAnyType, root);
    }

    private boolean contains(TreeAnyType treeAnyType, BinaryNode<TreeAnyType> t) {
        if (t == null) {
            return false;
        }
        int compare = treeAnyType.compareTo(t.treeAnyType);
        if (compare < 0) {
            return contains(treeAnyType, t.left);
        } else if (compare > 0) {
            return contains(treeAnyType, t.right);
        } else {
            return true;
        }
    }

    public BinaryNode<TreeAnyType> findMin() {
        if (isEmpty()) throw new NoSuchElementException();
        return findMin(root);
    }

    private BinaryNode<TreeAnyType> findMin(BinaryNode<TreeAnyType> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    public BinaryNode<TreeAnyType> findMax() {
        if (isEmpty()) throw new NoSuchElementException();
        return findMax(root);
    }

    private BinaryNode<TreeAnyType> findMax(BinaryNode<TreeAnyType> t) {
        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t;
        }
        return findMax(t.right);
    }


    public void insert(TreeAnyType treeAnyType) {
        root = insert(treeAnyType, root);
    }

    private BinaryNode<TreeAnyType> insert(TreeAnyType treeAnyType, BinaryNode<TreeAnyType> current) {
        if (current == null) {
            return new BinaryNode<>(treeAnyType, null, null);
        }

        int compareResult = treeAnyType.compareTo(current.treeAnyType);

        if (compareResult < 0) {
            current.left = insert(treeAnyType, current.left);
        } else if (compareResult > 0) {
            current.right = insert(treeAnyType, current.right);
        }

        return current;
    }


    public void remove(TreeAnyType treeAnyType) {
        root = remove(treeAnyType, root);
    }

    private BinaryNode<TreeAnyType> remove(TreeAnyType treeAnyType, BinaryNode<TreeAnyType> current) {

        if (current == null) {
            return null;
        }

        int compare = treeAnyType.compareTo(current.treeAnyType);

        if (compare < 0) {
            current.left = remove(treeAnyType, current.left);
        } else if (compare > 0) {
            current.right = remove(treeAnyType, current.right);
        } else if (current.left != null && current.right != null) {
            current = findMin(current);
            current.right = remove(treeAnyType, current.right);
        } else
            current = (current.left != null) ? current.left : current.right;

        return current;
    }

    public void printTree() {
    }


}
