package com.codeeval.primeToN;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
		    	try {
		    		int max = Integer.parseInt(line);
		    		boolean[] primes = getSieve(max);
		    		displayResult(primes);
		    	} catch (NumberFormatException e) {
		    		
		    	}
		    }
		} catch (IOException e) {
			
		}
	}
	
	public static void displayResult(boolean[] primes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				if (sb.length() != 0) {
					sb.append(",");
				}
				sb.append(i);
			}
		}
		System.out.println(sb);
	}
	
	public static boolean[] getSieve(int max) {
		boolean[] sieve = new boolean[max];
		Arrays.fill(sieve, true);
		sieve[0]=sieve[1]=false;
		for (int i = 2; i < sieve.length; i++) {
			if (sieve[i]) {
				for (int j = 2; i*j < sieve.length; j++) {
					sieve[i*j] = false;
				}
			}
		}
		return sieve;
	}
}
