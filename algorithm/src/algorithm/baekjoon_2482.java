package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class baekjoon_2482 {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	static int n, k;
	static int[] dp;
	
	static void solution() {
		
		int st = k+k-1-1;
		
		if(n>=st) return;
		
		dp[st] = 1;
		
		for(int i=st+1; i<n; i++) {

			dp[i] = dp[i-1];
			
			int num = i -
			
			
			
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n = Integer.parseInt(bf.readLine());
		k = Integer.parseInt(bf.readLine());
		
	}

}
