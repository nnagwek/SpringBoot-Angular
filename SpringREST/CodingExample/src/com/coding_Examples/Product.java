package com.coding_Examples;

import java.util.Scanner;

public class Product {

//	public static void main(String[] args) throws IOException {
//		
//		int numOfElements =0 ;
//		BigInteger prod =new BigInteger("1");
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        System.out.println("Enter no. of elements you want in array:");
//		numOfElements = Integer.parseInt(br.readLine()); 
////        System.out.println("Enter elements you want in array:");
//        
//		String  lines = br.readLine(); 
//        BigInteger[] arrayOfElements = new BigInteger[numOfElements];
//        String[] strs = lines.trim().split("\\s+");
//        
//        for (int i = 0; i < strs.length; i++) {
//        	arrayOfElements[i] = new BigInteger(strs[i]);
//        	prod = prod.multiply(arrayOfElements[i]);
//        	
//        }
//        System.out.println(prod);
//         
        
        public static void main(String[] args)

        {

            //System.out.println("Enter the number of elements");

            Scanner sc=new Scanner(System.in);

            int n=sc.nextInt();

            if(n>=1&&n<=1000)

            {

                long[] arr=new long[n];

                int i=0;

                //System.out.println("Enter the elements");

                for(;i<arr.length;i++)

                {

                    arr[i]=sc.nextInt();

                }

                long ans=1;

                int j=-1;

                long res=(long) Math.pow(10, 9);

                long res1=res+7;

                while(n>0)

                {

                    ans=(ans*arr[j+1])%res1;

                    j++;

                    n--;

                }

                System.out.println(ans);

            }

            sc.close();

        }
		
	}
//}

