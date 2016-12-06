package com.classes;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    
    protected List<Node> nodes;
    private String name;
    private String description;
    
    public Tree(String name) {
    	this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName (String n) { 
        this.name = n;
    }
    
    public String getDescription () {
        return description;
    }
    
    public void setDescription(String d) {
        this.description = d;
    }
    
    public void init(Node node, String presentation) {
        if (nodes == null) {
        	nodes = new ArrayList<Node>();
        }
        nodes.add(node);
        System.out.println("Tree has been initialized!");
    }
    
    public boolean isBalanced(Node root) {
    	if (root == null) {
    		return true;
    	} if (getHeight(root) == -1) {
    		return false;
    	}
    	return true;
    }
    
    public void addNode(Node node, Node parent) {
    	if (nodes == null) {
    		System.out.println("Tree has not ben initialized yet");
    	} else {
    		nodes.add(node);
    	}
    }
    
    public int getHeight(Node root) {
    	if (root == null) {
    		return 0;
    	}
    	
    	int leftHeight = getHeight(root.getLeft());
    	int rightHeight = getHeight(root.getRight());
    	
    	if (leftHeight == -1 || rightHeight == -1) {
    		return -1;
    	}
    	if (Math.abs(leftHeight - rightHeight) > 1) {
    		return -1;
    	}
    	return Math.max(leftHeight, rightHeight) + 1;
    	
    }
    
    public void printTree() {
        
    }
    
}
