package com.codeeval.detect_cycles;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;

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
		    	IndexHolder holder = cycleDetection(lineArray);
		    	if (holder != null) {
		    		int count = holder.lam;
		    		int index = holder.mu;
		    		StringBuilder sb = new StringBuilder();
		    		while (count > 0) {
		    			count--;
		    			sb.append(lineArray[index]);
		    			if (count != 0) {
		    				sb.append(' ');
		    			}
		    			index++;
		    		}
		    		System.out.println(sb.toString());
		    	}
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static IndexHolder cycleDetection(String[] lineArray) {
		int tortoise = 0;
		int hare = 0;     
        if (lineArray.length > 0) {
            tortoise = getNext(0, lineArray);
            hare = getNext(getNext(0, lineArray), lineArray);
            while (!(lineArray[tortoise].equals((lineArray[hare])))) {
            	tortoise = getNext(tortoise, lineArray);
            	hare = getNext(getNext(hare, lineArray), lineArray);
            }
        	
            int mu = 0;
            tortoise = 0;
            while (!(lineArray[tortoise].equals((lineArray[hare])))) {
            	tortoise = getNext(tortoise, lineArray);
            	hare = getNext(hare, lineArray);
            	mu++;
            }
            
            int lam = 1;
            hare = getNext(tortoise, lineArray);
            while (!(lineArray[tortoise].equals((lineArray[hare])))) {
            	hare = getNext(hare, lineArray);
            	lam++;
            }
            
            return new IndexHolder(mu, lam);
        }
        return null;
        
	}
	
	private static int getNext(int current, String[] lineArray) {
		int next = ++current;
		if (next == lineArray.length) {
			return lineArray.length-1;
		} else {
			return next;
		}
	}
	
	static class IndexHolder {
		int mu;
		int lam;
		
		public IndexHolder(int mu, int lam) {
			this.mu = mu;
			this.lam = lam;
		}
	}

}