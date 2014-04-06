package com.codeeval.morseCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
	
	private static final HashMap<String, Character> MORSE_CODE = new HashMap<String, Character>(36);
	static {
		MORSE_CODE.put(".-", 'A');
		MORSE_CODE.put("-...", 'B');
		MORSE_CODE.put("-.-.", 'C');
		MORSE_CODE.put("-..", 'D');
		MORSE_CODE.put(".", 'E');
		MORSE_CODE.put("..-.", 'F');
		MORSE_CODE.put("--.", 'G');
		MORSE_CODE.put("....", 'H');
		MORSE_CODE.put("..", 'I');
		MORSE_CODE.put(".---", 'J');
		MORSE_CODE.put("-.-", 'K');
		MORSE_CODE.put(".-..", 'L');
		MORSE_CODE.put("--", 'M');
		MORSE_CODE.put("-.", 'N');
		MORSE_CODE.put("---", 'O');
		MORSE_CODE.put(".--.", 'P');
		MORSE_CODE.put("--.-", 'Q');
		MORSE_CODE.put(".-.", 'R');
		MORSE_CODE.put("...", 'S');
		MORSE_CODE.put("-", 'T');
		MORSE_CODE.put("..-", 'U');
		MORSE_CODE.put("...-", 'V');
		MORSE_CODE.put(".--", 'W');
		MORSE_CODE.put("-..-", 'X');
		MORSE_CODE.put("-.--", 'Y');
		MORSE_CODE.put("--..", 'Z');
		MORSE_CODE.put(".----", '1');
		MORSE_CODE.put("..---", '2');
		MORSE_CODE.put("...--", '3');
		MORSE_CODE.put("....-", '4');
		MORSE_CODE.put(".....", '5');
		MORSE_CODE.put("-....", '6');
		MORSE_CODE.put("--...", '7');
		MORSE_CODE.put("---..", '8');
		MORSE_CODE.put("----.", '9');
		MORSE_CODE.put("-----", '0');
	}
	
	public static void main(String[] args) {
	    File file = new File(args[0]);
	    BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		    	StringBuilder decipherCode = new StringBuilder();
		    	String[] lineArray = line.split(" ");
		    	for (String code : lineArray) {
		    		if (MORSE_CODE.containsKey(code)) {
		    			decipherCode.append(MORSE_CODE.get(code));	
		    		} else {
		    			decipherCode.append(' ');
		    		}
		    		
		    	}
		    	System.out.println(decipherCode);
		    }
		    
		} catch (IOException e) {
			
		}
	}
}
