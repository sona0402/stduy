package com.sona.tree;

public class BinarySearchTest {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        // test tree is empty
        System.out.println(binarySearchTree.isEmpty());

        TreeAnyType treeAnyType = new TreeAnyType(10);
        binarySearchTree.insert(treeAnyType);

        // test tree is empty
        System.out.println(binarySearchTree.isEmpty());

        // insert two elem
        TreeAnyType one = new TreeAnyType(1);
        TreeAnyType two = new TreeAnyType(2);
        TreeAnyType three = new TreeAnyType(3);
        TreeAnyType four = new TreeAnyType(4);
        TreeAnyType eleven = new TreeAnyType(11);

        binarySearchTree.insert(one);
        binarySearchTree.insert(two);
        binarySearchTree.insert(three);
        binarySearchTree.insert(four);
        binarySearchTree.insert(eleven);

        // Get min
        System.out.println(binarySearchTree.findMin().getTreeAnyType().getData());
        // Get max
        System.out.println(binarySearchTree.findMax().getTreeAnyType().getData());

        System.out.println(binarySearchTree.contains(one));

    }
}
