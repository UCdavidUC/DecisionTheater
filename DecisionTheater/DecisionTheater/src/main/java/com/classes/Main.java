package com.classes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	
	public ArrayList<Object> screen01 = new ArrayList<Object>();
	public ArrayList<Object> screen02 = new ArrayList<Object>();
	public ArrayList<Object> screen03 = new ArrayList<Object>();
	public ArrayList<Object> screen04 = new ArrayList<Object>();
	public ArrayList<Object> screen05 = new ArrayList<Object>();
	public ArrayList<Object> screen06 = new ArrayList<Object>();
	public ArrayList<Object> screen07 = new ArrayList<Object>();
	
	private static ArrayList<Object> audioList = new ArrayList<Object>();
	private static ArrayList<MediaAbstract> mediaList = new ArrayList<MediaAbstract>();
	
	HashMap map = new HashMap();
	
    public static void main(String[] args) {
        
    	/*
    	Tree tree = new Tree();
        tree.init();
        
        Scene scene = new Scene(1920, 1080);
        scene.display();
        
        
                
        AudioClass audio = new AudioClass();
	        audio.setDelay(100);
	        audio.setDuration(3000);
	        audio.setPath("path");
	        audio.setxCoord(0);
	        audio.setyCoord(0);
	        
	    ImageClass image = new ImageClass();
	    	image.setDelay(100);
	    	image.setDuration(3000);
	    	image.setPath("Path");
	        image.setxCoord(0);
	        image.setyCoord(0);
	        
	    TextClass text = new TextClass();
	    	text.setDelay(100);
	    	text.setDuration(3000);
	    	text.setPath("Path");
	    	text.setxCoord(0);
	    	text.setyCoord(0);
	   
	    audio.printDetail("audio");
	    image.printDetail("image");
	    text.printDetail("text");
	    
	    */
        
	    File file = new File("src/main/java/com/classes/programa01.test");
	    
	    parse(file);
	    
        // TODO before using media, we need to validate that the media exist, otherwise we need to
        // throw MediaNotFoundException, so we need to create this exception specifying which is the error.
    }
    
    
    private static void display() {
    	
    }
    
    private static void parse(File file) {
    	ArrayList<String> lines = new ArrayList<String>();
    	String line;
    	int count = 0;
    	System.out.println("Parsing file..." + file);
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null) {
				lines.add(line);
				System.out.println((count + 1) + "\t"  + line);
				count ++;
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    	searchProgramDefinition(lines);
    }
    
    /**
     * M�todos del compilador
     * 
     * @param programLines
     */
    private static void searchProgramDefinition(ArrayList<String> programLines) {
	    for (int i = 0; i < programLines.size(); i++) {
	    	String[] lineElements = programLines.get(i).split("[ ,?!()\"]+");	  
	    	switch(lineElements[0].replaceAll("[^a-zA-Z0-9]","")) {
    	    	case "Definicion":
    	    		String programName = genProgramToken(lineElements);
    	    		System.out.println("Nombre del programa: " + programName);
    	    		break;
    	    	case "Secuencial":
    	    		String seqToken = genSequentialToken(lineElements);
    	    		System.out.println(seqToken);
    	    		break;
    	    	case "Paralelo":
    	    		genParallelToken(lineElements);
    	    		break;
    	    	case "Audio":
    	    		genAudioToken(lineElements);
    	    		break;
    	    	case "Fin":
    	    		endProgram();
    	    		break;
    	    	default:
    	    		//System.out.println("Found: " + lineElements[0]);
    	    		break;
	    	}
	    }
    }
    
    private static String genProgramToken(String[] line) {
    	boolean declaration = false;
    	String className = "";
    	for (int i = 0; i < line.length; i++) {
    		if (line[i].equals("Definicion")) {
    			declaration = true;
    		} else {
    			if (declaration == true) {
    				className = line[i].replaceAll("[^a-zA-Z0-9]",""); 
    			} else {
    				System.out.println("BadClassDeclException.java");
    			}
    		}
    	}
    	return className;
    }
    
    private static String genSequentialToken(String[] line) {    	
    	String mediaName = "";
    	String mediaType = "";
    	String mediaPath = "";
    	int delay = 0; //msec
    	int duration = 0; //msec
    	    	
    	if (line[0].replaceAll("[^a-zA-Z0-9]","").equals("Secuencial")) {
    		mediaName = line[2].replaceAll("[^a-zA-Z0-9]","");
    		mediaPath = line[3];
    		mediaType = line[4];
    		delay = Integer.parseInt(line[5]);
    		duration = Integer.parseInt(line[6]);
    	} else {
    		mediaName = "";
    		mediaPath = "";
    		mediaType = "";
    	}
    	
    	// Sequential object generation
    	switch(mediaType) {
    	case "Imagen":
    		ImageClass img = new ImageClass();
    		img.setDelay(delay);
    		img.setDuration(duration);
    		img.setName(mediaName);
    		img.setPath(mediaPath);
    		mediaList.add(img);
    		break;
    	case "Video": 
    		
    	}	
    	
    	return 	"Media type: " + mediaType + "\n" +
    			"Media name: " + mediaName + "\n" +
    			"Media path: " + mediaPath + "\n" +
    			"Delay: " + delay + "\n" +
    			"Duration: " + duration + "\n";
    	
    }
    
    private static void genParallelToken(String[] line) {
    	
    }
    
    private static void genAudioToken(String[] line) {
    	
    }

    private static void endProgram() {
    	System.out.println("Program closed");
    }
    
}