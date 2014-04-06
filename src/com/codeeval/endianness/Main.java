package com.codeeval.endianness;

import java.nio.ByteOrder;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
		  System.out.println("BigEndian");
		} else {
		  System.out.println("LittleEndian");
		}
	}
}
