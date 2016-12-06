package com.classes;

/**
 * Class Node
 * It contains the methods to define if it is a leaf node or just another node in the tree.
 * If it is a leaf node it will build the class using media, otherwise it will be composed of other nodes.
 */
public class Node {

    private Node left;
    private Node right;
    private MediaAbstract leftMedia;
    private MediaAbstract rightMedia;
    private boolean leaf;
    private boolean composition;
    
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public MediaAbstract getLeftMedia() {
        return leftMedia;
    }

    public void setLeftMedia(MediaAbstract leftMedia) {
        this.leftMedia = leftMedia;
    }

    public MediaAbstract getRightMedia() {
        return rightMedia;
    }

    public void setRightMedia(MediaAbstract rightMedia) {
        this.rightMedia = rightMedia;
    }

    public boolean isComposition() {
        return composition;
    }

    public void setComposition(boolean composition) {
        this.composition = composition;
    }
    
    public Node() {}
    
    public Node(Node right, Node left) {
        leaf = false;
        this.right = right;
        this.left = left;
    }
    
    public Node(MediaAbstract leftMedia, MediaAbstract rightMedia) {
        this.leftMedia = leftMedia;
        this.rightMedia = rightMedia;
    }
    
    public void addNode(Node newNode) {
        if (left == null) {
            left = newNode;
        } else {
            if (right == null) {
                right = newNode;
            } else {
                System.out.println("ERROR: Cannot add child node!");
            }
        }
    }
    
    public boolean isLeaf() {
        return leaf;
    }
    
    public void parallelRun() {
        // TODO: How it will be running in parallel?
    }
    
    public void sequentialRun() {
        // TODO: How it will be running sequentially?
    }
    
}
