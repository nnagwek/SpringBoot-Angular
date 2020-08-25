package com.coding_Examples;

import java.util.Scanner;



public class ToggleString {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();

		char[] charArrays = name.toCharArray();
		for (int i = 0; i < charArrays.length; i++) {
			if (Character.isUpperCase(charArrays[i])) {
				charArrays[i] = Character.toLowerCase(charArrays[i]);
			}
			else if(Character.isLowerCase(charArrays[i])) {
				charArrays[i] = Character.toUpperCase(charArrays[i]);
			}
		}
		String newString = new String(charArrays);
		System.out.println(newString);
	}
}
