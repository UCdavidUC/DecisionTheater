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
	
	@SuppressWarnings("rawtypes")
	private static HashMap map = new HashMap();
	private static int globalKey = 0;
	
	public static Tree tree = new Tree("Main tree");
	
    public static void main(String[] args) {
    	
	    File file = new File("src/main/java/com/classes/programa01.test");
	    
	    parse(file);
	    
	    display();
	    
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
     * Métodos del compilador
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
    	    		String seqToken = genMediaPresentationToken(lineElements, "Secuencial");
    	    		System.out.println(seqToken);
    	    		break;
    	    	case "Paralelo":
    	    		genMediaPresentationToken(lineElements, "Paralelo");
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
    
    @SuppressWarnings("unchecked")
	private static String genMediaPresentationToken(String[] line, String presentation) {    	
    	String mediaName = "";
    	String mediaType = "";
    	String mediaPath = "";
    	int delay = 0; //msec
    	int duration = 0; //msec
    	
    	Node node = new Node();
    	node.setPresentation(presentation);
    	    	    	
    	if (line[0].replaceAll("[^a-zA-Z0-9]","").equals("Secuencial")) {
    		mediaName = line[2].replaceAll("[^a-zA-Z0-9]","");
    		mediaPath = line[3];
    		mediaType = line[4];
    		delay = Integer.parseInt(line[5]);
    		duration = Integer.parseInt(line[6]);
    	}
    	
    	// Sequential object generation
    	switch(mediaType) {
    	case "Imagen":
    		ImageClass img = new ImageClass();
    		img.setDelay(delay);
    		img.setDuration(duration);
    		img.setName(mediaName);
    		img.setPath(mediaPath);
    		node.setMedia(img);
    		break;
    	case "Video": 
    		VideoClass video = new VideoClass();
    		video.setDelay(delay);
    		video.setDuration(duration);
    		video.setName(mediaName);
    		video.setPath(mediaPath);
    		node.setMedia(video);
    		break;
    	case "Texto":
    		TextClass text = new TextClass();
    		text.setDelay(delay);
    		text.setDuration(duration);
    		text.setName(mediaName);
    		text.setPath(mediaPath);
    		node.setMedia(text);

    		
    		break;
    	}
    	
    	map.put(globalKey, node);
		globalKey++;
    	    	
    	return 	"Media type: " + mediaType + "\n" +
    			"Media name: " + mediaName + "\n" +
    			"Media path: " + mediaPath + "\n" +
    			"Delay: " + delay + "\n" +
    			"Duration: " + duration + "\n";
    	
    }
    
    private static String genAudioToken(String[] line) {
    	String mediaName = "";
    	String mediaType = "";
    	String mediaPath = "";
    	int delay = 0; //msec
    	int duration = 0; //msec
    	
    	AudioClass audio = new AudioClass();
    	audio.setName(mediaName);
    	audio.setPath(mediaPath);
    	audio.setDelay(delay);
    	audio.setDuration(duration);
    	
    	audioList.add(audio);
    	
    	return 	"Media type: " + mediaType + "\n" +
		"Media name: " + mediaName + "\n" +
		"Media path: " + mediaPath + "\n" +
		"Delay: " + delay + "\n" +
		"Duration: " + duration + "\n";
    }

    private static void endProgram() {
    	System.out.println("Program closed");
    }
    
}
