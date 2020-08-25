package com.coding_Examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoyProfilePicture {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = Integer.parseInt(br.readLine());
		int numOfCases = Integer.parseInt(br.readLine());
		while (numOfCases > 0) {
			String lines = br.readLine();
			String[] strs = lines.trim().split("\\s+");
			long[] arrayOfElements = new long[strs.length];
			for (int i = 0; i < strs.length; i++) {
				arrayOfElements[i] = Long.parseLong(strs[i]);
			}
			if(arrayOfElements[0] < len || arrayOfElements[1] < len) {
				System.out.println("UPLOAD ANOTHER");
			}else if( arrayOfElements[0] == arrayOfElements[1]) {
				System.out.println("ACCEPTED");
			}else {
				System.out.println("CROP IT");
			}
			--numOfCases;
		}
	}
}
