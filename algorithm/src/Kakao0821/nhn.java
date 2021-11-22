package Kakao0821;

import java.util.*;

public class nhn {

	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<Integer> ans = new ArrayList<>();
	
	
	private static int lowerBound(ArrayList<Integer> data, int num) {
	    int l = 0;
	    int r = data.size();
	    
	    while(l < r) {
	    	int mid = (l + r) / 2;
	        
	        if(data.get(mid) >= num) {
	        	r = mid;
	        }
	        else {
	        	l = mid + 1;
	        }
	    }
	    return r;
	}
	
	private static int b(ArrayList<Integer> data, int num) {
	    int l = 0;
	    int r = data.size();
	    
	    while(l < r) {
	    	int mid = (l + r) / 2;
	        
	        if(data.get(mid) >= num) {
	        	r = mid;
	        }
	        else {
	        	l = mid + 1;
	        }
	    }
	    return r;
	}
	
	static void branch() {
		int num = arr.get(0);
		ans.add(num);
		arr.remove(0);
	}
	
	static void merge(int num) {
		
		int i = lowerBound(arr, num);
		arr.add(i, num);
		ans.remove(Integer.valueOf(num));
	}
	
	static void init() {
		
		for(int i=2;i<=100000; i++) arr.add(i);
		
	}

}
