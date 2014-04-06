package com.codeeval.penultimateWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    File file = new File(args[0]);
	    BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		    	String[] lineArray = line.split(" ");
		    	if (lineArray.length >= 2) {
		    		System.out.println(lineArray[lineArray.length - 2]);
		    	}
		    	
		    }
		} catch (IOException e) {
			
		}
	}
}
