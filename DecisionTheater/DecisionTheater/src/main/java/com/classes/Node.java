package com.classes;

/**
 * Class Node
 * It contains the methods to define if it is a leaf node or just another node in the tree.
 * If it is a leaf node it will build the class using media, otherwise it will be composed of other nodes.
 */
public class Node {

    private Node left;
    private Node right;
    private MediaAbstract media;
    private boolean composition;
    private String presentation;
    
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

    public MediaAbstract getMedia() {
        return media;
    }

    public void setMedia(MediaAbstract media) {
        this.media = media;
    }

    public boolean isComposition() {
        return composition;
    }

    public void setComposition(boolean composition) {
        this.composition = composition;
    }
    
    public Node() {}
    
    public Node(Node right, Node left) {
        this.right = right;
        this.left = left;
    }
    
    public Node(Node left, Node right, MediaAbstract media) {
        this.left = left;
        this.right = right;
        this.media = media;
    }
    
    public String getPresentation() {
    	return presentation;
    }
    
    public void setPresentation(String p) {
    	this.presentation = p;
    }
    
    public void parallelRun() {
        // TODO: How it will be running in parallel?
    }
    
    public void sequentialRun() {
        // TODO: How it will be running sequentially?
    }
    
}
