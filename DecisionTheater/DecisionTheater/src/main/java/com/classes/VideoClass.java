package com.classes;

import java.io.File;

public class VideoClass extends MediaAbstract {
    
    private float duration;     // msec
    private float delay;        // msec
    
    // Spatial
    // Screen position, considering screen resolution in pixel units.
    private float xCoord;  
    private float yCoord;
    
    // Media file and path
    private String path;        // Can be either a local path or remote path for web media.
    private File media;
    
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
    
    public VideoClass() {}
    
    public VideoClass(String path, float duration, float delay, float xCoord, float yCoord) {
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
		// TODO Auto-generated method stub
		
	}
    
}
