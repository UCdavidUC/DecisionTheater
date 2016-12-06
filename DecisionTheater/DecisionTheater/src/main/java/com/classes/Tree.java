package com.classes;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    
    protected List<Node> nodes;
    private String name;
    private String description;
    
    public String getName() {
        return name;
    }
    
    public void setName (String n) { 
        this.name = n;
    }
    
    public String getDescription () {
        return description;
    }
    
    public void setDescriptiion(String d) {
        this.description = d;
    }
    
    public void init() {
        Node root = new Node();
        if (nodes == null) {
        	nodes = new ArrayList<Node>();
        }
        nodes.add(root);
        System.out.println("Tree has been initialized!");
    }
    
    public boolean buildTree () {
        // TODO tree build will parse the input from the user.
        
        return true;
    }
    
    public void printTree() {
        
    }
    
}
