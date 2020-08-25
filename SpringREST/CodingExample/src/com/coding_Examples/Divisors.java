package com.coding_Examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Divisors {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String  lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		long[] arrayOfElements = new long[strs.length];
      for (int i = 0; i < strs.length; i++) {
      	arrayOfElements[i] = Long.parseLong(strs[i]);
      }
       
      long count=0;
      for(long i= arrayOfElements[0] ;i <= arrayOfElements[1] ;  i++ ) {
    	  if( i % arrayOfElements[2] == 0) {
    		  count ++;
    	  }
      }
       System.out.println(count);
		
	}

}
