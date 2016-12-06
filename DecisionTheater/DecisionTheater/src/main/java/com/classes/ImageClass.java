package com.classes;

import java.io.File;

public class ImageClass extends MediaAbstract {

    private String name;
    private String presentation;
	
	private float duration;     // msec
    private float delay;        // msec
    
    // Spatial
    // Screen position, considering screen resolution in pixel units.
    private float xCoord;  
    private float yCoord;
    
    // Media file and path
    private String path;        // Can be either a local path or remote path for web media.
    private File media;
    
    public String getName() {
    	return name;
    }
    
    public void setName(String n) {
    	this.name = n;
    }
    
    public String getPresentation() {
    	return presentation;
    }
    
    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public float getDelay() {
        return delay;
    }

    public void setDelay(float delay) {
        this.delay = delay;
    }

    public float getxCoord() {
        return xCoord;
    }

    public void setxCoord(float xCoord) {
        this.xCoord = xCoord;
    }

    public float getyCoord() {
        return yCoord;
    }

    public void setyCoord(float yCoord) {
        this.yCoord = yCoord;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getMedia() {
        return media;
    }

    // Temporal
    public void setMedia(File media) {
        this.media = media;
    }
    
    public ImageClass() {}
    
    public ImageClass(String name, String presentation, String path, float duration, float delay, float xCoord, float yCoord) {
        this.path = path;
        this.duration = duration;
        this.delay = delay;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    @Override
    void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void open() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean validatePath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	void printDetail(String cName) {
		System.out.println("Image class name: " + cName);
		System.out.print("Path: " + path + ", delay: " + delay + ", duration:" + duration + ", coordinates in x: " + xCoord + ", coordinates in y: " + yCoord);
		System.out.println();
	}

}
