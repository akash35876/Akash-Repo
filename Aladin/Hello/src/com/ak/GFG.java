package com.ak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GFG {
	static int getPairsCount(int[] arr, int n, int k) {
			Map<Integer, Integer> frequencyMap = new HashMap<>();
	        int count = 0;
	
	        // Count the frequency of each element in the array
	        for (int i = 0; i < n; i++) {
	            int complement = k - arr[i];
	            
	            // If complement exists in the map, increment count by the frequency of the complement
	            if (frequencyMap.containsKey(complement)) {
	                count += frequencyMap.get(complement);
	            }
	
	            // Update the frequency of the current element in the map
	            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
	        }
	
	        return count;
		 
	    }
	static boolean hasArrayTwoCandidates(int arr[], int n, int k) {
	    // Create a HashSet to store elements encountered so far
	    HashSet<Integer> set = new HashSet<>();

	    for (int i = 0; i < n; i++) {
	        int complement = k - arr[i];
	        
	        // Check if the complement exists in the set
	        if (set.contains(complement)) {
	            return true; // Found a pair whose sum is K
	        }
	        
	        // Add the current element to the set
	        set.add(arr[i]);
	    }
	    
	    return false; // No pair found whose sum is K
	}

public static void main(String[] args) {
	int[] arr = {1, 5, 6, 3, 6, 2, 8, 4};
    int k = 8;
    int n = arr.length;

    int pairsCount = getPairsCount(arr, n, k);
    boolean boolcount = hasArrayTwoCandidates(arr, n, k);
    System.out.println("Number of pairs whose sum is equal to " + k + ": " + pairsCount);
    System.out.println(boolcount);
}

}
