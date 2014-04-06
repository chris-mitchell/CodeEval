package com.codeeval.telephonepermutations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

	private static final HashMap<Character, String> TELEPHONE = new HashMap<Character, String>(10);
	static {
		TELEPHONE.put('0', "0");
		TELEPHONE.put('1', "1");
		TELEPHONE.put('2', "abc");
		TELEPHONE.put('3', "def");
		TELEPHONE.put('4', "ghi");
		TELEPHONE.put('5', "jkl");
		TELEPHONE.put('6', "mno");
		TELEPHONE.put('7', "pqrs");
		TELEPHONE.put('8', "tuv");
		TELEPHONE.put('9', "wxyz");
		
	}
	
	private static boolean mHasPrinted = false;
	
	public static void main(String[] args) {
 	    File file = new File(args[0]);
	    BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {	
		    	getPermutations(line, "");
		    	System.out.println();
		    	mHasPrinted = false;
		    }
		} catch (IOException e) {
			
		}
	}
	
	private static void getPermutations(String prefix, String data) {
		
		String letters = TELEPHONE.get(prefix.charAt(0));
		String remaining = prefix.substring(1);
		
		for (int i = 0; i < letters.length(); i++) {
			String result = data + letters.charAt(i);
			if (remaining.length() != 0) {
				getPermutations(remaining, result);
			} else {
				if (!mHasPrinted) {
					mHasPrinted = true;
				} else {
					System.out.print(',');
				}
				
				System.out.print(result);
			}
		}
	}
}
