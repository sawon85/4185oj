package algorithm;

import java.util.Scanner;

public class baekjoon_2003 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n, m;
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		long sum = 0;
		int ans = 0;
		
		int[] arr = new int[10000];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int j = -1;
		for(int i=0; i<n; i++) {

			if(j>=n) break;
			
			while(sum<m) {
				
				j++;
				if(j>=n) break;
				
				sum += arr[j];

			}
			
			if(sum==m) ans++;
			
			sum -= arr[i];
			
		}
		
		System.out.println(ans);
		
	}
	
}
