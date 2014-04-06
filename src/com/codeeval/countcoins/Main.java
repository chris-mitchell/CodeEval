package com.codeeval.countcoins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	private static final int[] COINS = {5, 3, 1};
	
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
		    	countCoins(value);
		    	
		    }
		} catch (IOException e) {
			
		}
	}
	
	private static void countCoins(int value) {
		int coinCount = 0;
		for (int coinValue : COINS) {
			while (true) {
				if (coinValue <= value) {
					value -= coinValue;
					coinCount++;
				} else {
					break;
				}
			}
		}
		System.out.println(coinCount);
	}
}
