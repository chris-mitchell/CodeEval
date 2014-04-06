package com.codeeval.sumints;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0l;
	    File file = new File(args[0]);
	    BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		    	try {
		    		int lineInt = Integer.parseInt(line);
			    	sum = sum + lineInt;	
		    	} catch (NumberFormatException e) {
		    		//
		    	}
		    }
		} catch (IOException e) {
			
		}
		System.out.println(sum);

	}

}
