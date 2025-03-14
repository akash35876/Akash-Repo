package com.ak;

public class AddTwooarray {
	
	public static void main(String[] args) {
	        int[] array1 = {1, 2, 3};
	        int[] array2 = {4, 5, 6};

	        int[] mergedArray = new int[array1.length + array2.length];

	        // Copy elements of array1 to mergedArray
	        System.arraycopy(array1, 0, mergedArray, 0, array1.length);

	        // Copy elements of array2 to mergedArray
	        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);

	        // Print the merged array
	        for (int num : mergedArray) {
	            System.out.print(num + " ");
	        }
	}
	

}
