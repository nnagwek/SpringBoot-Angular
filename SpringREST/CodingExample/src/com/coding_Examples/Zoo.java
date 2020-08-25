package com.coding_Examples;

import java.util.*;

public class Zoo {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
//        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        
        int len = name.trim().length();
        int indexOfO = name.trim().toLowerCase().indexOf('o');
        int noOfOs = len - indexOfO;
        int noOfZs = len -noOfOs ;
//        System.out.println( "X = "+ noOfOs + " Y= "+ noOfZs);
        if(noOfZs * 2 == noOfOs)
        	System.out.println("Yes");
        else {
        	System.out.println("No");
        }
	}

}
