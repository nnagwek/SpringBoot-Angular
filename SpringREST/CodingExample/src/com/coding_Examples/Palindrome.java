package com.coding_Examples;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next().trim();
		boolean isTrue = true;
		int len = name.length();
		char[] namesArr = name.toCharArray();

		for (int i = len - 1, j = 0; (i > (len - 1) / 2 && j <= (len - 1) / 2); i--, j++) {
			if (Character.compare(namesArr[i], namesArr[j]) != 0) {
				isTrue = false;
				continue;
			}
		}
		if (isTrue) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
