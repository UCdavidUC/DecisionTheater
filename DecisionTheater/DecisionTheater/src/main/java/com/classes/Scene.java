package com.classes;

import java.util.List;

public class Scene {

    private float width;
    private float heigth;
    
    private List<Object> controls;
    
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeigth() {
        return heigth;
    }

    public void setHeigth(float heigth) {
        this.heigth = heigth;
    }

    public List<Object> getControls() {
        return controls;
    }

    public void setControls(List<Object> controls) {
        this.controls = controls;
    }
    
    public Scene() {}
    
    public Scene(float width, float height) {
        this.width = width;
        this.heigth = height;
    }
    
    public void display() {
        
    }
    
}
