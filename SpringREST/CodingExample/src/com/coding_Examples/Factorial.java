package com.coding_Examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long  num = Long.parseLong(br.readLine()); 
		long fact= 1;
		fact = factorial(num);
		System.out.println(fact);
	}
	
	public static long factorial(long num) {
		if (num ==0) {
			return 1;
		}
		else {
			return num* factorial(num-1);
		}
	}
}
