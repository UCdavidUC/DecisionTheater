package com.classes;

public abstract class MediaAbstract {
    
    abstract boolean validatePath();
        
    abstract void display();
    
    abstract void open(); // TODO open file, initializes the file in memory and loads it.
    
    abstract void close(); // TODO close, closes the file stream and deletes the ocupied memory space
    
    abstract void printDetail(String cName);

}
