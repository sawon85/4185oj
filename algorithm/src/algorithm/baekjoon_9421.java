package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class baekjoon_9421 {
	
	static Scanner sc = new Scanner(System.in);
	static HashMap<Integer,Boolean> map = new HashMap<>();
	static boolean[] array;
	
	static boolean solution(int n, HashSet<Integer> set) {
		
		if(map.containsKey(n)) return map.get(n);
		
		String number = Integer.toString(n);
		int ans = 0;
		
		for(int i=0; i<number.length(); i++) {
			ans += Math.pow(number.charAt(i)-'0', 2);
		}

		if(ans == 1) return true;
		if(set.contains(ans)) return false;

		set.add(ans);
		Boolean result = solution(ans, set);
		map.put(ans, result);
		
		return result;
		
	}

	static void sosu(int n) {
		
		 for(int i=2; i<=n; i++)
	            for(int j=i*2; j<=n; j+=i)
	                 array[j] = true;
	}
	
	public static void main(String[] args) {
		
		map.put(0, false);
		map.put(1, true);
		
		int n = sc.nextInt();
		
		array = new boolean[n+1];
		sosu(n);
		
		for(int i=2; i<n; i++) {
			
			if(array[i]) continue;
			
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(i);
			if(solution(i, set)) {
				System.out.println(i);
			}	
				
		}
	
		
	}
}
