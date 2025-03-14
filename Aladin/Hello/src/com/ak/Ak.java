package com.ak;

import java.util.ArrayList;
import java.util.Collections;

public class Ak {

	private static int maxEle;

	public static ArrayList<Integer> main(String[] args) {

		int a[] = { 16, 17, 4, 3, 5, 2 };
		int n = 6;

		maxEle = a[n - 1];

		ArrayList<Integer> res = new ArrayList<>();

		extracted(a, res, maxEle);

		Collections.reverse(res);

		return res;

	}

	private static void extracted(int[] a, ArrayList<Integer> res, int i) {
		int maxEle;
		maxEle = a[i];

		res.add(maxEle);
	}

}

		  
//        if(a[0]>=a[1]){
//            System.out.println(a[1]);
//        }if(a[1]>=a[2]){
//            System.out.println(a[2]);
//        }if(a[2]>=a[3]){
//            System.out.println(a[3]);
//        }if(a[3]>=a[4]){
//            System.out.println(a[4]);
//        }if(a[4]>=a[5]){
//            System.out.println(a[5]);
//        }else{
//            System.out.println(a[6]);
//        }
//        System.out.println(a[4]);

		
		
			
