package com.coding_Examples;
import java.util.*;

public class SeatingArrangement {

//	INPUT
//	First line of input will consist of a single integer T denoting number of test-cases. 
//	Each test-case consists of a single integer N denoting the seat-number.
//
//	OUTPUT
//	For each test case, print the facing seat-number and the seat-type, separated by a single 
//	space in a new line.
	
//	SAMPLE INPUT  
//	2
//	18
//	40
	
//	SAMPLE O/P
//	19 WS
//	45 AS
	public static void checkseatNumber(int num) {
		if (num %12  == 1 ) {
			checkSeatType(num + 11);
		}else if(num %12  == 2 ) {
			checkSeatType(num + 9);
		}else if(num %12  == 3 ) {
			checkSeatType(num + 7);
		}else if(num %12  == 4 ) {
			checkSeatType(num + 5);
		}else if(num %12  == 5 ) {
			checkSeatType(num + 3);
		}else if(num %12  == 6 ) {
			checkSeatType(num + 1);
		}else if(num %12  == 7 ) {
			checkSeatType(num - 1);
		}else if(num %12  == 8 ) {
			checkSeatType(num - 3);
		}else if(num %12  == 9 ) {
			checkSeatType(num - 5);
		}else if(num %12  == 10 ) {
			checkSeatType(num - 7);
		}else if(num %12  == 11 ) {
			checkSeatType(num - 9);
		}else if(num %12  == 0 ) {
			checkSeatType(num - 11);
		}
		
		
	}

	public static void checkSeatType(int num){
        if (num % 12 == 1 || num % 12 == 6 || num % 12 == 7  || num % 12 == 0) {
        	System.out.println(num + " WS");
        }
        else if ( num % 12 == 2 || num % 12 == 5 || num % 12 == 11 || num % 12 == 8) {
        	System.out.println(num + " MS");
        }else if ( num % 12 == 3 || num % 12 == 4 || num % 12 == 9  || num % 12 == 10) {
        	System.out.println(num + " AS");
        }

    }
public static void main(String[] args) {
	 	Scanner sc=new Scanner(System.in); 
	   int num=sc.nextInt(); 
	   while(num-->0){ 
	       int n=sc.nextInt(); 
	       checkseatNumber(n); 
	   }
}
	
  
}
