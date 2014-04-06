package com.codeeval.TextValue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	private static final String[] LOW_NUMBERS = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static final String[] HIGH_NUMBERS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private static final String[] UNITS = {"", "Thousand", "Million", "Billion"};
	private static final String DOLLARS = "Dollars";
	private static final String HUNDRED = "Hundred";
	
	public static void main(String[] args) {
	    File file = new File(args[0]);
	    BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		    	StringBuilder output = new StringBuilder();
		    	
		    	ArrayList<Integer> data = organizeData(line);
		    	int i = 0;
		    	int size = data.size();
		    	while (i < size) {
		    		String toAppend = processThreePlaces(data.get(i));
		    		if (toAppend.length() > 0) {
		    			output.append(toAppend + UNITS[size-i-1]);
		    		}
		    		i++;
		    	}
		    	System.out.println(output.append(DOLLARS));
		    }
		} catch (IOException e) {
			
		} catch (NumberFormatException e) {
			
		}
	}
	
	private static ArrayList<Integer> organizeData(String line) throws NumberFormatException {
    	int i = line.length();
    	ArrayList<Integer> values = new ArrayList<Integer>();
    	while (i > 0) {
    		String substring;
    		if (i - 3 >= 0) {
    			substring = line.substring(i-3, i);
    			i -= 3;
    		} else {
    			substring = line.substring(0, i);
    			i = -1;
    		}
    		int data = Integer.parseInt(substring);
    		values.add(0, data);
    	}
    	return values;
	}
	
	private static String processThreePlaces(int value) {
		StringBuilder result = new StringBuilder();
		if (value != 0) {
			if (value >= 100) {
				result.append(LOW_NUMBERS[value/100]).append(HUNDRED);
				value %= 100;
			}
			if (value <= 19) {
				result.append(LOW_NUMBERS[value]);
			} else {
				result.append(HIGH_NUMBERS[value/10]);
				value %= 10;
				if (value > 0) {
					result.append(LOW_NUMBERS[value]);
				}
			}
		}
		return result.toString();
	}
}
