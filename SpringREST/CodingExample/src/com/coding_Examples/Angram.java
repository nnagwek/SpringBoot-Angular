package com.coding_Examples;

import java.util.Scanner;

public class Angram {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt(); 
		   while(num>0){ 
			   String name = sc.next().trim();
		       String name1 = sc.next().trim();
		       checkanagram(name, name1); 
		       num--;
		  }
	}
	public static void checkanagram(String name, String name1) {

		char[] characters = name.toCharArray();
        for( char  myName : characters) {
        	 String s=Character.toString(myName); 
        	if(name1.contains(s)) {
        		name= name.replaceFirst(s, "");
        		name1 = name1.replaceFirst(s, "");
        	}
        }
        int sum = name.length() + name1.length();
        System.out.println(sum);
	}
}
