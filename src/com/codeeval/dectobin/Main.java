package com.codeeval.dectobin;

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
		    	int value = Integer.parseInt(line);
		    	computeBinary(value);
		    	
		    }
		} catch (IOException e) {
			
		}
	}
	
	private static void computeBinary(int value) {
		StringBuilder binary = new StringBuilder();
		for (int power = 32; power >= 0; power--) {
			int exponential = (int) Math.pow(2, power);
			if (exponential <= value) {
				value -= exponential;
				binary.append('1');
			} else {
				binary.append('0');
			}
		}
		System.out.println(binary.toString().replaceFirst("^0+(?!$)", ""));
	}
}
